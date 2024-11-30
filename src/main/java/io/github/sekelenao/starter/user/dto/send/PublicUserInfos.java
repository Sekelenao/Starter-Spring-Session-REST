package io.github.sekelenao.starter.user.dto.send;

import io.github.sekelenao.starter.util.Assertions;

import java.util.Objects;

public record PublicUserInfos(long userID, String displayName) {

    public PublicUserInfos {
        Objects.requireNonNull(displayName);
        Assertions.nonBlank(displayName);
    }

}
