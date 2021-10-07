package org.example.ship;

import org.example.Board;
import org.example.Orientation;
import org.example.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Config.BOARD_COLUMNS;
import static org.example.Config.BOARD_ROWS;
import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
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

    /**
     * Given an origin point and a direction to face, ships should be able to generate the relative cords they
     * would take up based on its shape
     */
    @Test
    void generateCords() {
        //battleship generateCords test
        Orientation direction = Orientation.North;
        Position origin = new Position(3,3);
        Position[] expected = new Position[battleship1.getLength()];
        //populate expected
        for(int i = 0; i < battleship1.getLength(); i++){
            expected[i] = new Position(origin.getX_value(), i+ origin.getY_value());
        }
        Position[] result = battleship1.generateCords(origin, direction);

        for(int i = 0; i < battleship1.getLength(); i++){
            assertEquals(expected[i].getX_value(), result[i].getX_value());
            assertEquals(expected[i].getY_value(), result[i].getY_value());
        }

        //minesweeper generateCords test
        direction = Orientation.North;
        origin = new Position(1,3);
        expected = new Position[minesweeper1.getLength()];
        //populate expected
        for(int i = 0; i < minesweeper1.getLength(); i++){
            expected[i] = new Position(origin.getX_value(), i+ origin.getY_value());
        }
        result = minesweeper1.generateCords(origin, direction);

        for(int i = 0; i < minesweeper1.getLength(); i++){
            assertEquals(expected[i].getX_value(), result[i].getX_value());
            assertEquals(expected[i].getY_value(), result[i].getY_value());
        }

        //destroyer generateCords test
        direction = Orientation.West;
        origin = new Position(7,8);
        expected = new Position[destroyer1.getLength()];
        //populate expected
        for(int i = 0; i < destroyer1.getLength(); i++){
            expected[i] = new Position(origin.getX_value()-i, origin.getY_value());
        }
        result = destroyer1.generateCords(origin, direction);

        for(int i = 0; i < destroyer1.getLength(); i++){
            assertEquals(expected[i].getX_value(), result[i].getX_value());
            assertEquals(expected[i].getY_value(), result[i].getY_value());
        }
    }
}