package utils;

public class TestAssertions {

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("Assertion failed: " + message);
        }
    }

    public static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                    "Assertion failed: " + message +
                            " | expected=" + expected +
                            " actual=" + actual
            );
        }
    }

    public static void assertThrows(Class<? extends RuntimeException> exception,
                                    Runnable action,
                                    String message) {
        try {
            action.run();
            throw new AssertionError("Expected exception was not thrown: " + message);
        } catch (RuntimeException e) {
            if (!exception.isInstance(e)) {
                throw new AssertionError(
                        "Wrong exception type: " + e.getClass().getSimpleName()
                );
            }
        }
    }
}