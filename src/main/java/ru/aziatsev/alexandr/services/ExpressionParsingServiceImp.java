package ru.aziatsev.alexandr.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParsingServiceImp implements ExpressionParsingService {
    @Override
    public ArrayList<String> ParseExpression(String line) {
        ArrayList<String> list = new ArrayList<>();
        String regex = "\\d+\\.\\d+|\\d+|\\+|-|/|\\*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        list = TransformNotation(list);
        return list;
    }

    private ArrayList<String> TransformNotation(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+") ||
                    list.get(i).equals("-") ||
                    list.get(i).equals("*") ||
                    list.get(i).equals("/")) {
                Collections.swap(list, i, i + 1);
                i++;
            }
        }
        return list;
    }

}
