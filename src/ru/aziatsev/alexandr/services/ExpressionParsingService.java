package ru.aziatsev.alexandr.services;

import java.util.LinkedList;

public interface ExpressionParsingService {
    LinkedList<String> ParseExpression(String line);

}
