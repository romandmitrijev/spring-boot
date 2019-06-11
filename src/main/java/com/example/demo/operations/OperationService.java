package com.example.demo.operations;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperationService {

    Map<String, Operation> operationsMap;

    public OperationService(List<Operation> operations) {
        operationsMap = new HashMap<>();
        for(Operation operation : operations) {
            if (operation.name() == null)
                continue;

            operationsMap.put(operation.name(), operation);
        }
    }

    public Integer calculate(Integer n1, Integer n2, String op) {
        Operation operation = operationsMap.get(op);
        return operation.calculate(n1, n2);
    }
}
