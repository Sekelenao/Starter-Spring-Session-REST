package io.github.sekelenao.skdocs;

import io.github.sekelenao.skdocs.user.entity.UserEntity;
import io.github.sekelenao.skdocs.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public final class InitialisationProcess implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger(InitialisationProcess.class.getName());

    private static final String DEFAULT_USER_CREATION_ARG = "withUser";

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public InitialisationProcess(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        if(args.containsOption(DEFAULT_USER_CREATION_ARG)){
            createDefaultUser(args.getOptionValues(DEFAULT_USER_CREATION_ARG));
            LOGGER.warning("Default admin created. See documentation to disable.");
        }
    }

    private void saveDefaultUser(String username, String password) {
        userRepository.save(new UserEntity(username, password, username));
    }

    private void createDefaultUser(List<String> options) {
        if(options.size() < 2 || options.get(0).isBlank() || options.get(1).isBlank()) {
            throw new IllegalArgumentException(DEFAULT_USER_CREATION_ARG + " option requires at least a password and a username," +
                    " see documentation.");
        }
        if(options.size() > 2) {
            throw new IllegalArgumentException("Only one admin account can be provided per boot.");
        }
        saveDefaultUser(options.get(0), passwordEncoder.encode(options.get(1)));
    }

}
