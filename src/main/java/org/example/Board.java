package org.example;

public class Board {
    private int[][] boardState;
    private int cols;
    private int rows;

    public Board(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        this.boardState = new int[cols][rows];
    }
}
