package com.example.demo.users;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoUserRepository implements UserRepository {

    @Override
    public String getInfo() {
        return "Get from Mongo";
    }

    @Override
    public void setInfo() {

    }

    @Override
    public String name() {
        return "MONGO";
    }
}
