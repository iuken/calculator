package ru.aziatsev.alexandr;

import ru.aziatsev.alexandr.services.ConsoleServiceImp;
import ru.aziatsev.alexandr.services.ExpressionParsingServiceImp;
import ru.aziatsev.alexandr.services.SolvingServiceImp;
import ru.aziatsev.alexandr.services.ValidateServiceImp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConsoleServiceImp cs = new ConsoleServiceImp();
        ValidateServiceImp vs = new ValidateServiceImp();
        ExpressionParsingServiceImp exps = new ExpressionParsingServiceImp();
        SolvingServiceImp ss = new SolvingServiceImp();

        String line = "";
        ArrayList<String> expression;
        String result = null;
        line = cs.ReadExpression();
        boolean isValid = vs.IsValid(line);

        while (!isValid || result == null) {
            if (!isValid) {
                line = cs.ReadExpression();
                isValid = vs.IsValid(line);
            } else {
                try {
                    expression = exps.ParseExpression(line);
                    result = ss.Solve(expression);
                } catch (ArithmeticException ex) {
                    System.err.println("Error: Divide by zero, type valid expression:");
                    line = cs.ReadExpression();
                }
            }
        }
        cs.Write(line + " = " + result);
    }
}
