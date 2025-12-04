package utils;

public class RandomGenerator {
    private static java.util.Random random;

    static {
        // Use project‑wide unique seed from IDUtil
        random = new java.util.Random(IDUtil.getProjectSeed());
    }

    /**
     * Returns a random integer within the specified range.
     */
    public static int nextInt(int min, int max) {
        if (min > max) throw new IllegalArgumentException("min cannot be greater than max");
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Returns a random boolean value.
     */
    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    /**
     * Returns a random element from an array.
     */
    public static <T> T choice(T[] array) {
        if (array == null || array.length == 0) return null;
        return array[random.nextInt(array.length)];
    }

    /**
     * Resets the random generator using the project seed.
     * Useful for reproducible test scenarios.
     */
    public static void reset() {
        random = new java.util.Random(IDUtil.getProjectSeed());
    }
}
