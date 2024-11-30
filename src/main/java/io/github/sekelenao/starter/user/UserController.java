package io.github.sekelenao.starter.user;

import io.github.sekelenao.starter.user.dto.send.PublicUserInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public final class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/public-infos")
    public ResponseEntity<PublicUserInfos> publicUserInfos(Authentication authentication, @RequestParam Optional<String> username) {
        var targetUsername = username.orElse(authentication.getName());
        return userService.publicUserInfos(targetUsername)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
