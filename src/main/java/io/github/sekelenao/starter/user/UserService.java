package io.github.sekelenao.starter.user;

import io.github.sekelenao.starter.user.dto.send.PublicUserInfos;
import io.github.sekelenao.starter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Service class for managing user-related operations.
 *
 * <p>This class provides methods for retrieving user information from the
 * {@link UserRepository}. It offers functionality to fetch both public and
 * complete user information based on either username or user ID.</p>
 *
 * @see UserRepository
 */
@Service
public final class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves the public user information for a given username.
     *
     * <p>This method attempts to find the corresponding user in the repository.
     * If a user is found, it returns an {@link Optional} containing {@link PublicUserInfos}.
     * If no user is found, it returns an empty {@link Optional}.</p>
     *
     * @param username the username of the user whose public information is to be retrieved
     * @return an {@link Optional} containing {@link PublicUserInfos} if the user is found,
     *         or an empty {@link Optional} if the user does not exist
     * @throws NullPointerException if the provided username is null
     */
    public Optional<PublicUserInfos> publicUserInfos(String username) {
        Objects.requireNonNull(username);
        return userRepository.findByUsername(username)
                .map(UserRepository::toPublicUserInfos);
    }

}

