package ru.aziatsev.alexandr.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleServiceImp implements ConsoleService{
    @Override
    public String ReadExpression() {
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
