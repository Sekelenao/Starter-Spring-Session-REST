package io.github.sekelenao.starter.util;

import java.util.Arrays;
import java.util.Objects;

/**
 * Utility class providing assertions to validate input conditions.
 * This class cannot be instantiated.
 */
public final class Assertions {

    /**
     * Private constructor to prevent instantiation of this utility class.
     * Throws an {@link AssertionError} when called.
     */
    private Assertions() {
        throw new AssertionError("You cannot instantiate this class.");
    }

    /**
     * Ensures that all provided objects are non-null.
     *
     * @param objects an array of objects to check for nullity
     * @throws NullPointerException if the array itself is null or any of its elements are null
     */
    public static void requireNonNulls(Object... objects) {
        Arrays.stream(Objects.requireNonNull(objects))
                .forEach(Objects::requireNonNull);
    }

    /**
     * Ensures that the provided string is not blank (empty or containing only whitespace).
     *
     * @param string the string to check for blankness
     * @throws IllegalArgumentException if the string is blank
     */
    public static void nonBlank(String string) {
        if (string.isBlank()) throw new IllegalArgumentException("Cannot be blank");
    }

    /**
     * Ensures that the provided integer is positive.
     *
     * @param number the integer to check for positivity
     * @throws IllegalArgumentException if the integer is negative
     */
    public static void positive(int number) {
        if (number < 0) throw new IllegalArgumentException(number + " cannot be negative.");
    }

}
