package com.example.demo.operations;

import org.springframework.stereotype.Component;

@Component
public class MultiplicationOperation implements Operation {
    @Override
    public Integer calculate(Integer n1, Integer n2) {
        return n1 * n2;
    }

    @Override
    public String name() {
        return "MULT";
    }
}
