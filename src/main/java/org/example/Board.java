package org.example;

import org.example.exceptions.InputException;
import org.example.exceptions.ShipPlacementException;
import org.example.nature.SeaTile;
import org.example.nature.Tile;
import org.example.ship.Ship;
import org.example.ship.ShipTile;

public class Board {

    private Tile[][] locations;
    private Ship[] fleet;

    private int cols;
    private int rows;

    public Board(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        this.locations = new Tile[cols][rows];
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                locations[i][j] = new SeaTile();
            }
        }
    }

    public boolean placeShip(Ship ship, Position coordinate, Orientation direction){
        if(!placeable(ship, coordinate, direction)){
            return false;
        }
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

        ShipTile[] tiles = ship.getTiles();
        for(int i = 0; i < tiles.length; i++){
            locations[coordinate.getX_value() + i*xChange][coordinate.getY_value() + i*yChange] = tiles[i];
        }
        return true;
    }

    private boolean placeable(Ship ship, Position origin, Orientation direction){

        Position p = new Position(origin.getX_value(), origin.getY_value());

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

        //check for on board placement and ship collision
        for(int i = 0; i < ship.getLength(); i++){
            p.setX_value(origin.getX_value() + i*xChange);
            p.setY_value(origin.getY_value() + i*yChange);
            //check for on board placement
            if(!inBounds(p)){
                valid = false;
                throw new ShipPlacementException("Ship placement out of bounds!");
            }
            //check for ship collision
            if(!(locations[p.getX_value()][p.getY_value()] instanceof SeaTile)){
                valid = false;
                throw new ShipPlacementException("Ship placement collides with an existing ship!");
            }
        }

        return valid;
    }

    private boolean inBounds(Position coordinate){
        boolean valid = true;
        int x = coordinate.getX_value();
        int y = coordinate.getY_value();
        if(x < 0 || x >= this.cols){
            valid = false;
        }
        if(y < 0 || y >= this.rows){
            valid = false;
        }
        return valid;
    }

    //   getPositions will return a single Position object if object takes up a single tile,
    //   Otherwise, it will return a list of coordinates with the origin of the object being the first
    //TODO - figure out where the origin will be in return list
    public Position getPosition(Placeable object){
        for(int i = 0; i < this.cols; i++){
            for(int j = 0; j < this.rows; j++){
                if(locations[i][j] == object){
                    return new Position(i,j);
                }
            }
        }
        return null;
    }

    public Tile getObject(Position coord){
        return this.locations[coord.getX_value()][coord.getY_value()];
    }

    public Ship[] getFleet(){
        return this.fleet;
    }
}
