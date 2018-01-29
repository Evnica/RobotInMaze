package com.evnica.maze;

/**
 * Class: Location
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class Location
{
    private int x;
    private int y;

    public Location( int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(int x, int y){
        return  this.x == x && this.y == y;
    }

    @Override
    public boolean equals( Object obj ) {
        return obj instanceof Location && ((Location)obj).getX() == this.x && ((Location)obj).getY() == this.y;
    }

    @Override
    public String toString()
    {
        return "[" + x + ", " + y + "] ";
    }
}
