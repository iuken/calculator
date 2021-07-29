package ru.aziatsev.alexandr.services;

public class ValidateServiceImp implements ValidateService{


    @Override
    public boolean isValid(String expression) {
        boolean isValid = expression.matches("^\\+|^\\-|^\\/|^\\*|^\\d+");
        if (!isValid){
            System.out.println("некоректные симовлы");
        }
        return false;
    }
}
