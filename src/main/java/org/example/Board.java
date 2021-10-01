package org.example;

import org.example.ship.Ship;

public class Board {
    private int[][] boardState;
    private int cols;
    private int rows;

    public Board(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        this.boardState = new int[cols][rows];
    }

    public boolean placeShip(Ship ship, Position coordinate, Orientation direction){
        return false;
    }

    private boolean placeable(Ship ship, Position coordinate, Orientation direction){
        return false;
    }
}
