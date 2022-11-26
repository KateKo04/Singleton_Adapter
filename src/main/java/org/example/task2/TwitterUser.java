package org.example.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TwitterUser {
    private String email;
    private Country userCountry;
    private LocalDate getUserActiveTime;
}
