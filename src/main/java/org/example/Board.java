package org.example;

import org.example.exceptions.InputException;
import org.example.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //   In each cell, contains an ID that points to a unique object stored in the object's hashmap
    //   Object identification for those being placed on the board begins at 10
    private Placeable[][] locations;
    private Ship[] fleet;

    private int cols;
    private int rows;

    public Board(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        this.locations = new Placeable[cols][rows];
    }

    public boolean placeShip(Ship ship, Position coordinate, Orientation direction){
        if(!placeable(ship, coordinate, direction)){
            return false;
        }

        return true;
    }

    private boolean placeable(Ship ship, Position origin, Orientation direction){

        Position p = origin;

        int xChange = 0;
        int yChange = 0;
        boolean valid = true;

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
            default:
                throw new InputException("Invalid Ship orientation input, expected one of: North, South, East, West");
        }

        for(int i = 0; i < ship.getLength(); i++){
            p.setX_value(origin.getX_value() + i*xChange);
            p.setY_value(origin.getY_value() + i*yChange);
            if(!inBounds(p)){
                valid = false;
                break;
            }
        }
        return valid;
    }

    private boolean inBounds(Position coordinate){
        boolean valid = true;
        int x = coordinate.getX_value();
        int y = coordinate.getY_value();
        if(x < 0 || x > this.cols){
            valid = false;
        }
        if(y < 0 || y > this.rows){
            valid = false;
        }
        return valid;
    }

    //   getPositions will return a single Position object if object takes up a single tile,
    //   Otherwise, it will return a list of coordinates with the origin of the object being the first
    //TODO - figure out where the origin will be in return list
    public List<Position> getPosition(Placeable object){
        List<Position> positions = new ArrayList<>();
        return positions;
    }

    public Placeable getObject(Position coord){
        return this.locations[coord.getX_value()][coord.getY_value()];
    }

    public Ship[] getFleet(){
        return this.fleet;
    }
}
