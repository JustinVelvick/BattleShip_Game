package org.example.ship;

public class Battleship extends Ship{

    public Battleship(){
        super();
        this.setLength(4);
        this.makeTiles();
    }

    public Battleship(String name) {
        super(name);
        this.setLength(4);
        this.makeTiles();
    }



}
