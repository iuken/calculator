package ru.aziatsev.alexandr.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SolvingServiceImpTest {

    static private SolvingServiceImp ss;

    @BeforeAll
    static private void setUp(){
        ss = new SolvingServiceImp();
    }

    @ParameterizedTest
    @MethodSource("ru.aziatsev.alexandr.services.Providers#TestDivisionProvider")
    @DisplayName("Method SolvingServiceImp.solve(List<String> expression)")
    public void TestDivision() {
        List<String> expression = new ArrayList<>();
        expression.add("105");
        expression.add("9");
        expression.add("/");
        double expected = Double.parseDouble("11.666666");
        double actual = Double.parseDouble(ss.Solve(expression));
        double delta = 0.000001;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void TestDivisionByZero() {
        List<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("0");
        expression.add("/");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ss.Solve(expression);
        });
    }

    @Test
    public void TestSolving() {
        List<String> expression = new ArrayList<>();
        expression.add("5");
        expression.add("100");
        expression.add("+");
        expression.add("3");
        expression.add("*");
        expression.add("57");
        expression.add("-");
        expression.add("3");
        expression.add("/");
        String expected = "86.0";
        String actual = ss.Solve(expression);
        assertEquals(expected, actual);
    }

}
