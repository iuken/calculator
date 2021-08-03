package ru.aziatsev.alexandr.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class SolvingServiceImp implements SolvingService {
    @Override
    public String Solve(List<String> list) throws ArithmeticException {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+\\.\\d+|\\d+")) {
                stack.push(s);
            } else {
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                double result = 0;
                switch (s) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
                        if (num2 - 0 < Double.MIN_VALUE){
                            throw new ArithmeticException();
                        }
                        result = num1 / num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return stack.pop();
    }

}
