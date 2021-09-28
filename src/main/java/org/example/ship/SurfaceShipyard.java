package org.example.ship;

import org.example.Config;

//this concrete ShipYard factory is responsible for all ships that reside on the sea surface
public class SurfaceShipyard extends ShipYard {

    //default constructor
    @Override
    public Ship createShip(ShipType type) {
        Ship newShip = new Minesweeper();
        switch(type){
            case Minesweeper:
                newShip = new Minesweeper();
            case Destroyer:
                newShip = new Destroyer();

            case Battleship:
                newShip = new Battleship();
        }
        return newShip;
    }

    //constructor with specific name
    @Override
    public Ship createShip(ShipType type, String name) {
        Ship newShip = new Minesweeper();
        switch(type){
            case Minesweeper:
                newShip = new Minesweeper(name);
            case Destroyer:
                newShip = new Destroyer(name);

            case Battleship:
                newShip = new Battleship(name);
        }
        return newShip;
    }
}
