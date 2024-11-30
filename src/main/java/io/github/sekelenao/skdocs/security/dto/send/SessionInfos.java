package io.github.sekelenao.skdocs.security.dto.send;

import io.github.sekelenao.skdocs.util.Assertions;

import java.util.Objects;

public record SessionInfos(String connectedAs) {

    public SessionInfos {
        Objects.requireNonNull(connectedAs);
        Assertions.nonBlank(connectedAs);
    }

}
