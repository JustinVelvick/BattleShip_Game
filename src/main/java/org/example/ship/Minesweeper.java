package org.example.ship;

public class Minesweeper extends Ship{

    public Minesweeper(){
        super();
        this.setLength(2);
        this.makeTiles();
    }
    public Minesweeper(String name) {
        super(name);
        this.setLength(2);
        this.makeTiles();
    }
}
