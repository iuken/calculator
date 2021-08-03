package ru.aziatsev.alexandr.services;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ValidateServiceImpTest {


    @Test
    @DisplayName("Empty input")
    public void TestEmptyInput() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid(""));
    }
    @Test
    @DisplayName("Letters input")
    public void TestLetterInput() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid("3+d"));
    }

    @Test
    @DisplayName("Double sign input")
    public void TestDoubleSignInput() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid("1**9"));
    }

    @Test
    @DisplayName("Starts with sign")
    public void TestStartsWithSign() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid("-9+6"));
    }

    @Test
    @DisplayName("Ends with sign")
    public void TestEndsWithSign() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid("6+6-"));
    }

    @Test
    @DisplayName("Symbols input")
    public void TestSymbolsInput() {
        ValidateServiceImp vs = new ValidateServiceImp();
        assertFalse(vs.IsValid("5+20%"));
    }

}