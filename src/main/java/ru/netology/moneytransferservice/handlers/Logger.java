package ru.netology.moneytransferservice.handlers;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public void log(String msg) {

        String note = new StringBuilder().append("[" + LocalDateTime
                .now()
                .format(DateTimeFormatter
                        .ofPattern("dd-MM-yyyy HH:mm  ")) + "] " + msg + "\n").toString();

        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(note);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static Logger logger;
    private Logger() {}


    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return  logger;
    }
}
