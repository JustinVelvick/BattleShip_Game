package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testMethod() {
        Game game = new Game();
        String result = game.testMethod();
        String expected = "Hello world!";
        assertEquals(result, expected);
    }
}