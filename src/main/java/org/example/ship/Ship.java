package org.example.ship;

import org.example.Config;
import org.example.Orientation;
import org.example.Placeable;
import org.example.Position;


/**
 * With all ships, a name can be specified, if not then Config.DEFAULT_SHIP_NAME will be used.
 * Ship class HAS ShipTiles that know their parent ship.
 * Ships and ShipTiles are decoupled from location and have no idea where they are.
 */
public abstract class Ship implements Placeable {
    private int length;
    private ShipTile[] tiles;
    private String name;

    public Ship(){
        this.name = Config.DEFAULT_SHIP_NAME;
    }

    public Ship(String name){
        this.name = name;
    }

    protected void makeTiles(){
        this.tiles = new ShipTile[this.length];
        for(int i=0; i < this.length; i++){
            tiles[i] = new ShipTile(this);
        }
    }

    public Position[] generateCords(Position origin, Orientation direction){
        Position[] cords = new Position[getLength()];

        int xChange = 0;
        int yChange = 0;
        switch(direction){
            case North:
                yChange = 1;
                break;
            case South:
                yChange = -1;
                break;
            case East:
                xChange = 1;
                break;
            case West:
                xChange = -1;
                break;
        }

        for(int i = 0; i < getLength(); i++){
            cords[i] = new Position((origin.getX_value() + i*xChange), (origin.getY_value() + i*yChange));
        }
        return cords;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipTile[] getTiles() {
        return tiles;
    }
}
