package org.example.ship;

import org.example.nature.Tile;

public class ShipTile extends Tile {
    Ship parent;
    boolean shot;
    public ShipTile(Ship parentShip){
        this.parent = parentShip;
        this.shot = false;
    }

    public boolean isShot() {
        return shot;
    }
}
