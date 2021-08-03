package ru.aziatsev.alexandr.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsoleServiceImp implements ConsoleService {
    @Override
    public String ReadExpression() {
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Pattern.compile("\\s").matcher(line).find()) {
            System.err.println("Warning: spaces will be ignored");
            line = line.replaceAll("\\s", "");
        }
        return line;
    }

    @Override
    public void Write(String line) {
        System.out.print(line);
    }
}
