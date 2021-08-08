package ru.aziatsev.alexandr.services;


import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    private Providers() {

    }

    public static Stream<Arguments> TestDivisionProvider() {
        return Stream.of(
                arguments("Hello, hello, hello, how low?", ", he", "Hellollollo, how low?"),
                arguments("Ahahahahaha", "ha", "A"),
                arguments("London is the capital of Great Britain", "Russia", "London is the capital of Great Britain")
        );
    }
}
