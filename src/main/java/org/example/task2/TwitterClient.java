package org.example.task2;

import java.time.LocalDate;

import java.time.LocalDate;

public class TwitterClient implements Client {
    private final TwitterUser user;

    public TwitterClient(TwitterUser user) {
        this.user = user;
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getCountry() {
        return user.getUserCountry().toString();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return user.getGetUserActiveTime();
    }
}
