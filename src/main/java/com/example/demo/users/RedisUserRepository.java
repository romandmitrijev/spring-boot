package com.example.demo.users;

import org.springframework.stereotype.Repository;

@Repository
public class RedisUserRepository implements UserRepository {
    @Override
    public String getInfo() {
        return "HEllo from Redis";
    }

    @Override
    public void setInfo() {

    }

    @Override
    public String name() {
        return "REDIS";
    }
}
