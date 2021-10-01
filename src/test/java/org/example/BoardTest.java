package org.example;

import org.example.ship.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Config.BOARD_COLUMNS;
import static org.example.Config.BOARD_ROWS;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    //Board
    Board board;

    //Shipyard and accompanying ships
    ShipYard shipYard;

    Ship battleship1;
    Ship destroyer1;
    Ship minesweeper1;

    @BeforeEach
    void setUp() {
        board = new Board(BOARD_COLUMNS,BOARD_ROWS);
        shipYard = new SurfaceShipyard();
        battleship1 = shipYard.createShip(ShipType.Battleship);
        destroyer1 = shipYard.createShip(ShipType.Destroyer);
        minesweeper1 = shipYard.createShip(ShipType.Minesweeper);
    }

    @Test
    void placeShip() {
        //place a ship with valid coordinates onto an empty board
        Position good_coordinates = new Position(3,6);
        Orientation direction_s = Orientation.South;
        assertTrue(board.placeShip(battleship1, good_coordinates, direction_s));
        //try placing a second ship with the SAME coordinates on the board
        assertFalse(board.placeShip(destroyer1, good_coordinates, direction_s));
        //    now try placing a ship with different coordinates, but ones that would cause overlapping
        //    with above already placed battleship
        Position overlapping_cords = new Position(2,5);
        Orientation direction_e = Orientation.East;
        assertFalse(board.placeShip(minesweeper1, overlapping_cords, direction_e));
    }

    @Test
    void placeShip_badInput(){
        //place a ship with BAD origin coordinates onto the board
        Position bad_coordinates = new Position(BOARD_COLUMNS+1,BOARD_ROWS+3);
        Orientation direction_e = Orientation.East;
        assertFalse(board.placeShip(battleship1, bad_coordinates, direction_e));
        //place a ship with GOOD origin coordinates, but a direction that causes partial off board placement
        //Here we are placing of the very Eastern edge of the board, but w/ eastern placement, ship will go off
        Position good_coordinates = new Position(BOARD_COLUMNS-1,5);
        assertFalse(board.placeShip(battleship1, good_coordinates, direction_e));
    }

    @Test
    void placeShip_edgeCases(){
        //place a ship with GOOD coordinates, but on the edge of the board, pointing in (West)
        Position good_coordinates = new Position(BOARD_COLUMNS-1,7);
        Orientation direction_w = Orientation.West;
        assertTrue(board.placeShip(battleship1, good_coordinates, direction_w));

        //place a ship with GOOD coordinates, but on the edge of the board, pointing down (South)
        good_coordinates = new Position(4,BOARD_ROWS-1);
        Orientation direction_s = Orientation.South;
        assertTrue(board.placeShip(destroyer1, good_coordinates, direction_s));
    }
}