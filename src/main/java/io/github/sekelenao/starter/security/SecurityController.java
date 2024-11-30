package io.github.sekelenao.starter.security;

import io.github.sekelenao.starter.security.dto.send.SessionInfos;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public final class SecurityController {

    @GetMapping("/infos")
    public ResponseEntity<SessionInfos> userInfos(Authentication authentication) {
        return ResponseEntity.ok(new SessionInfos(authentication.getName()));
    }

}
