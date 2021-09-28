package org.example.ship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceShipyardTest {

    ShipType type;

    Ship battleShip;
    Ship destroyerShip;
    Ship minesweeperShip;

    SurfaceShipyard shipyard;
    @BeforeEach
    void setUp(){
        shipyard = new SurfaceShipyard();
    }
    @Test
    void createShips() {
        //testing battleship creation with default name
        type = ShipType.Battleship;
        battleShip = new Battleship("Default Ship Name");
        Ship returnShip = shipyard.createShip(type);
        assertEquals(returnShip.getName(), battleShip.getName());

        //testing battleship creation with a user specified name
        type = ShipType.Battleship;
        battleShip = new Battleship("Skipper");
        returnShip = shipyard.createShip(type, "Skipper");
        assertEquals(returnShip.getName(), battleShip.getName());
    }
}