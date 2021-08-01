package ru.aziatsev.alexandr.services;

import java.util.regex.Pattern;

public class ValidateServiceImp implements ValidateService {


    @Override
    public boolean isValid(String expression) {
        if (expression == null || expression.equals("")) {
            System.err.println("Error: expression is empty, type correct expression:");
            return false;
        }
        if (Pattern.compile("[a-zA-Z]").matcher(expression).find()) {
            System.err.println("Error: expression contains letters, type correct expression:");
            return false;
        }
        if (Pattern.compile("[+\\-*/][+\\-*/]").matcher(expression).find()) {
            System.err.println("Error: expression contains a double operation sign, type correct expression:");
            return false;
        }
        if (Pattern.compile("^[+\\-*/]").matcher(expression).find()) {
            System.err.println("Error: operation sign at the beginning of an expression, type correct expression:");
            return false;
        }
        if (Pattern.compile("[+\\-*/]$").matcher(expression).find()) {
            System.err.println("Error: operation sign at the end of an expression, type correct expression:");
            return false;
        }
        if (Pattern.compile("[^+*/\\-\\d+\\s\\.]").matcher(expression).find()) {
            System.err.println("Error: unacceptable symbols, type correct expression:");
            return false;
        }
        return true;
    }
}
