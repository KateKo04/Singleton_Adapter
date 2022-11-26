package org.example.task3;

public class Authorization{
    public boolean authorize(БазаДаних db) {
        db.отриматиДаніКористувача();
        return true;
    }
}
