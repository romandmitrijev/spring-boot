package com.example.demo.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class UserService {

    private Map<String, UserRepository> userRepositories;

    public UserService(List<UserRepository> repositories) {
        userRepositories = repositories.stream()
                .collect(toMap(UserRepository::name, it -> it));
    }

    public String userInfo(String type) {
        UserRepository userRepository = userRepositories.get(type);
        return userRepository.getInfo();
    }
}
