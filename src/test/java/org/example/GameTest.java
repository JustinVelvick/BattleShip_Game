package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    Player player1;
    Player player2;
    Board board1;
    Board board2;

    int cols = 10;
    int rows = 10;

    @BeforeEach
    void setUp() {
        player1 = new Player("Dave");
        player2 = new Player("Jimmy");
        board1 = new Board(cols, rows);
        board2 = new Board(cols, rows);
    }

    //creates a game and needs to have players, boards, and ships created
    @Test
    void gameStartup(){
        game = new Game(player1, player2);
        assertSame(game.getPlayer1(), player1);
        assertSame(game.getPlayer2(), player2);
    }
}