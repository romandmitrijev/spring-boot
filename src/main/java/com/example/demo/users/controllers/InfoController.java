package com.example.demo.users.controllers;

import com.example.demo.operations.OperationService;
import com.example.demo.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {

    @Autowired
    UserService userService;

    @Autowired
    OperationService operationService;

    @RequestMapping(method = RequestMethod.GET, path = "/info")
    public String info(@RequestParam("type") String type) {
        return userService.userInfo(type);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/calculations")
    public Integer calculations(@RequestParam("n1") Integer n1,
                                @RequestParam("n2") Integer n2,
                                @RequestParam("op") String operations) {
        return operationService.calculate(n1, n2, operations);
    }
}
