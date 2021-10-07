package org.example.ship;

import org.example.Config;
import org.example.Placeable;
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
        String battleShip_default_name = Config.DEFAULT_SHIP_NAME;
        type = ShipType.Battleship;
        Ship returnShip = shipyard.createShip(type);
        assertEquals(returnShip.getName(), battleShip_default_name);
        ShipTile[] tiles = returnShip.getTiles();

        assertEquals(4, tiles.length);
        for(ShipTile tile: tiles){
            assertFalse(tile.isShot());
        }

        //testing battleship creation with a user specified name
        type = ShipType.Battleship;
        String expected_name = "Skipper";
        returnShip = shipyard.createShip(type, "Skipper");
        assertEquals(returnShip.getName(), expected_name);
    }
}