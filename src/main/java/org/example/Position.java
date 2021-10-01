package org.example;

public class Position {
    private int x_value;
    private int y_value;

    public Position(int x, int y){
        this.x_value = x;
        this.y_value = y;
    }

    public int getX_value() {
        return x_value;
    }

    public void setX_value(int x_value) {
        this.x_value = x_value;
    }

    public int getY_value() {
        return y_value;
    }

    public void setY_value(int y_value) {
        this.y_value = y_value;
    }
}
