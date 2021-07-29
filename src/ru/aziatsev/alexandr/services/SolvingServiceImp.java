package ru.aziatsev.alexandr.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class SolvingServiceImp implements SolvingService {
    @Override
    public String solve(List<String> list) throws ArithmeticException{
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                double num1 = Double.parseDouble(stack.pop());
                double num2 = Double.parseDouble(stack.pop());
                double result = 0;
                switch (s) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
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

    public String solve (List<String> list, int scale){
        String line = this.solve(list);
        BigDecimal result = new BigDecimal(line);
        return String.valueOf(result.setScale(scale));
    }
}
