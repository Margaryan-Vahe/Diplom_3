package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    public static String uniqEmail() {
        String ts = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
        return "auto_" + ts + "_" + ThreadLocalRandom.current().nextInt(1000, 9999) + "@example.com";
    }
    public static String name() { return "AutoUser"; }
    public static String password(int len) {
        String base = "Qwerty123";
        return len <= base.length() ? base.substring(0, len) : base + "x".repeat(len - base.length());
    }
}
