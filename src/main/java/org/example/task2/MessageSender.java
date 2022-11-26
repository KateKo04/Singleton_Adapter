package org.example.task2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class MessageSender {

    public static boolean send(String text, Client user, String country){
        if (Objects.equals(user.getCountry(), country)
                && Duration.between(user.getLastActiveTime(), LocalDate.now()).toMinutes() <= 60){
            System.out.println(text);
            return true;
        }
        return false;
    }

}
