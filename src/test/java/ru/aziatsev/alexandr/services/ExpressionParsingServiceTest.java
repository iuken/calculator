package ru.aziatsev.alexandr.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExpressionParsingServiceTest {

    static private ExpressionParsingServiceImp eps;

    @BeforeAll
    static private void setUp() {
        eps = new ExpressionParsingServiceImp();
    }

    @Test
    public void TestParsing() {
    }
}
