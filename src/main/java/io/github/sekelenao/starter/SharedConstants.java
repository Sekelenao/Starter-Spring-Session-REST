package io.github.sekelenao.starter;

public final class SharedConstants {

    private SharedConstants() {
        throw new AssertionError("You cannot instantiate this class.");
    }

    public static final int MAX_USERNAME_LENGTH = 55;

    public static final int MAX_DISPLAY_NAME_LENGTH = 15;

    public static final int MIN_PASSWORD_LENGTH = 8;

    public static final int MAX_PASSWORD_LENGTH = 255;

}
