package org.example.task3;


public class DataBase extends БазаДаних{
    public String retrieveUserData() {
        return super.отриматиДаніКористувача();
    }

    public String retrieveStaticData() {
        return super.отриматиСтатистичніДані();
    }
}
