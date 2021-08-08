package ru.aziatsev.alexandr.services;

import java.util.regex.Pattern;

public class ValidateServiceImp implements ValidateService {


    @Override
    public boolean IsValid(String expression) {
        return !IsEmpty(expression) &&
                !IsContainLetters(expression) &&
                !IsDoubleSing(expression) &&
                !IsBeginsWithSign(expression) &&
                !IsEndsWithSign(expression) &&
                !IsContainsSymbols(expression);
    }

    private boolean IsEmpty(String expression) {
        if (expression == null || expression.equals("")) {
            System.err.println("Error: expression is empty, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsContainLetters(String expression) {
        if (IsMatch(expression, "[a-zA-Z]")) {
            System.err.println("Error: expression contains letters, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsDoubleSing(String expression) {
        if (IsMatch(expression, "[+\\-*/][+\\-*/]")) {
            System.err.println("Error: expression contains a double operation sign, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsBeginsWithSign(String expression) {
        if (IsMatch(expression, "^[+\\-*/]")) {
            System.err.println("Error: operation sign at the beginning of an expression, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsEndsWithSign(String expression) {
        if (IsMatch(expression, "[+\\-*/]$")) {
            System.err.println("Error: operation sign at the end of an expression, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsContainsSymbols(String expression) {
        if (IsMatch(expression, "[^+*/\\-\\d+\\s\\.]")) {
            System.err.println("Error: unacceptable symbols, type correct expression:");
            return true;
        }
        return false;
    }

    private boolean IsMatch(String expression, String s) {
        return Pattern.compile(s).matcher(expression).find();
    }
}
