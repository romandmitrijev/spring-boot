package com.example.demo.users;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRepository implements UserRepository {

    @Override
    public String getInfo() {
        return "User Info from Mysql";
    }

    @Override
    public void setInfo() {
        System.out.println("Setting to mysql");

    }

    @Override
    public String name() {
        return "MYSQL";
    }
}
