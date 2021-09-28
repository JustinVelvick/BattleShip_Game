package org.example.ship;

//ShipYard implements the Factory design pattern and encapsulates object creation

public abstract class ShipYard {
    public abstract Ship createShip(ShipType type);
    public abstract Ship createShip(ShipType type, String name);
}
