package com.solid.dip;

public class PasswordRetriever {

    private final MySqlConnection mySqlConnection;

    public PasswordRetriever() {
        this.mySqlConnection = new MySqlConnection();
    }

    public MySqlConnection getMySqlConnection() {
        return mySqlConnection;
    }
}
