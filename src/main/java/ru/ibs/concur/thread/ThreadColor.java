package ru.ibs.concur.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ThreadColor {

    ANSI_RESET("\u001B[0m", ""),
    ANSI_RED("\u001B[31m", "redThread"),
    ANSI_GREEN("\u001B[32m", "greenThread"),
    ANSI_YELLOW("\u001b[33m", "yellowThread"),
    ANSI_BLUE("\u001B[34m", "blueThread"),
    ANSI_PURPLE("\u001B[35m", "purpleThread"),
    ANSI_CYAN("\u001B[36m", "cyanThread"),
    ANSI_WHITE("\u001b[37m", "whiteThread");

    private final String color;

    private final String threadName;

    public static ThreadColor getByThreadName(String threadName) {
        return Arrays.stream(ThreadColor.values())
                .filter(v -> v.threadName.equals(threadName))
                .findFirst().orElse(ThreadColor.ANSI_WHITE);
    }

}
