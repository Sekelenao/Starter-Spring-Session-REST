package io.github.sekelenao.skdocs.user.dto.send;

import io.github.sekelenao.skdocs.util.Assertions;

import java.util.Objects;

public record PublicUserInfos(long userID, String displayName) {

    public PublicUserInfos {
        Objects.requireNonNull(displayName);
        Assertions.nonBlank(displayName);
    }

}
