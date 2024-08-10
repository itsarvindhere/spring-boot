package com.example.aopdemo;

public class Account {
    private String name;
    private String level;

    public Account(String level, String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
