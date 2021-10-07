package org.example.ship;

public class Destroyer extends Ship{
    public Destroyer() {
        super();
        this.setLength(3);
        this.makeTiles();
    }
    public Destroyer(String name) {
        super(name);
        this.setLength(2);
        this.makeTiles();
    }
}
