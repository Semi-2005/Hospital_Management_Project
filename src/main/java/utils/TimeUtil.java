package utils;

public class TimeUtil {
    // Convert "HH:MM" to total minutes for comparison
    public static int toMinutes(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    // Compare times: returns negative if t1 < t2, zero if equal, positive if t1 > t2
    public static int compare(String t1, String t2) {
        return toMinutes(t1) - toMinutes(t2);
    }

    // Check if time is within a doctor's working window
    public static boolean isWithin(String time, String start, String end) {
        int t = toMinutes(time);
        return t >= toMinutes(start) && t <= toMinutes(end);
    }

    // Validate format "HH:MM"
    public static boolean isValidFormat(String time) {
        return time != null && time.matches("\\d{2}:\\d{2}");
    }

    // Format hours and minutes to "HH:MM"
    public static String format(int hour, int minute) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid hour or minute values.");
        }
        return String.format("%02d:%02d", hour, minute);
    }

    // Get current time in "HH:MM"
    public static String now() {
        java.time.LocalTime t = java.time.LocalTime.now();
        return String.format("%02d:%02d", t.getHour(), t.getMinute());
    }
}
