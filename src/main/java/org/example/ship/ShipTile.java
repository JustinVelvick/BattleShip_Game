package org.example.ship;

import org.example.Placeable;

public class ShipTile implements Placeable {
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
