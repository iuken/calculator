package ru.aziatsev.alexandr.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleServiceImpTest {

    static private ConsoleServiceImp cs;

    @BeforeAll
    static private void setUp(){
        cs = new ConsoleServiceImp();
    }

    @Test
    public void TestReadExpression(){
        String inputLine = "2 + 2";
        InputStream is = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(is);
        String expected = "2+2";
        String actual = cs.ReadExpression();
        assertEquals(expected, actual);
        System.setIn(System.in);
    }

    @Test
    public void TestWrite(){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        cs.Write("1+9*2");
        String expected = "1+9*2";
        String actual = os.toString();
        assertEquals(expected, actual);
        System.setOut(System.out);
    }
}
