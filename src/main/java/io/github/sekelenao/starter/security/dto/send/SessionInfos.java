package io.github.sekelenao.starter.security.dto.send;

import io.github.sekelenao.starter.util.Assertions;

import java.util.Objects;

public record SessionInfos(String connectedAs) {

    public SessionInfos {
        Objects.requireNonNull(connectedAs);
        Assertions.nonBlank(connectedAs);
    }

}
