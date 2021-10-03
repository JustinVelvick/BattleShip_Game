package org.example.ship;

import org.example.Config;
import org.example.Placeable;

//With all ships, a name can be specified, if not then Config.DEFAULT_SHIP_NAME will be used

public class Ship implements Placeable {
    private int length;
    private String name;

    public Ship(String name){
        this.name = name;
    }

    public Ship(){
        this.name = Config.DEFAULT_SHIP_NAME;
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
}
