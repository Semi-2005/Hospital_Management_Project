package utils;

public class IDUtil {
    // Primary student IDs
    private static final long STUDENT_ID_1 = 230316066L;//Semi's Student Id
    private static final long STUDENT_ID_2 = 230316060L;//Yigit's Student Id

    // Combined seed for randomness (unique project behavior)
    private static final long PROJECT_SEED = STUDENT_ID_1 ^ STUDENT_ID_2;

    /**
     * Returns a unique seed used across the project
     * for generating reproducible pseudo‑random data.
     */
    public static long getProjectSeed() {
        return PROJECT_SEED;
    }

    /**
     * Generates a salted hash integer based on an input string.
     * This ensures lookups or hashed structures differ uniquely per group.
     */
    public static int saltedHash(String input) {
        if (input == null) return 0;
        return (int) ((input.hashCode() ^ STUDENT_ID_1) + STUDENT_ID_2);
    }

    /**
     * Utility for debugging: prints both IDs.
     */
    public static String getIDInfo() {
        return "IDs: " + STUDENT_ID_1 + " & " + STUDENT_ID_2 + " | Seed: " + PROJECT_SEED;
    }
}
