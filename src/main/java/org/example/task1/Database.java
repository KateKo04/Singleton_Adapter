package org.example.task1;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@NoArgsConstructor
public class Database {
    static Connection c = null;
    static Statement stmt = null;
    static int id = 1;

    public void openConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void createUserTable(){
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE USER " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " EMAIL        CHAR(50))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void userInsert(User user){
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO USER (ID,NAME,AGE,EMAIL) " +
                    "VALUES (?,?,?,?);";
            PreparedStatement statement = c.prepareStatement(sql);
//            stmt.executeUpdate(sql);
            statement.setString(1, String.valueOf(id++));
            statement.setString(2, user.getName());
            statement.setString(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.executeBatch();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void saveAndClose(){
        try {
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
