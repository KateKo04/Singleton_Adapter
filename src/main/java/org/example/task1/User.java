package org.example.task1;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private String email;
    private int age;
    public static Database database = new Database();

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public String getAge() {
        return String.valueOf(age);
    }

    public static void main(String[] args) {
        User user1 = new User("Oles", "dobosevych@ucu.edu.ua", 31);
        database.openConnection();
//        database.createUserTable();
        database.userInsert(user1);
        database.saveAndClose();
    }
}
