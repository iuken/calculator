package ru.aziatsev.alexandr.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConsoleServiceImpTest {

    @Test
    public void TestReadExpression(){
        ConsoleServiceImp cs = new ConsoleServiceImp();

        String inputLine = "2 + 2";
        InputStream is = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(is);
        assertEquals("2+2", cs.ReadExpression());
        System.setIn(System.in);
    }

    @Test
    public void TestWrite(){
        ConsoleServiceImp cs = new ConsoleServiceImp();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        cs.Write("1+9*2");
        assertEquals("1+9*2", os.toString());
        System.setOut(System.out);

    }
}
