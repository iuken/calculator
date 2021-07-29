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

        String line = null;
        ArrayList<String> expression;
        String result = null;
        line = cs.ReadExpression();

        while (!vs.isValid(line)) {
            try {
                expression = exps.ParseExpression(line);
                try{
                    result = ss.solve(expression);
                } catch (ArithmeticException ex){
                    System.err.println("Error: Divide by zero, type valid expression:");
                    line = cs.ReadExpression();;
                }
            } catch (Exception ex){
                System.err.println("Error: Type valid expression:");
                line = cs.ReadExpression();;
            }
        }
        cs.write(line + " = " + result);


	// write your code here
    }
}
