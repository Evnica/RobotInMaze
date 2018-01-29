package com.evnica.maze;

/**
 * Class: Node
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class Node
{
    private boolean isWall = false;
    private Location predecessor;
    private Location location;
    private int distance;

    public Node( Location predecessor, Location location, int distance ) {
        this.predecessor = predecessor;
        this.location = location;
        this.distance = distance;
    }

    public Node (int x, int y, int distance){
        this.location = new Location( x, y );
        this.distance = distance;
    }

    public Node( boolean isWall ) {
        this.isWall = isWall;
    }

    public int getX() {
        return location.getX();
    }

    public int getY(){
        return location.getY();
    }

    public int getPredecessorX(){
        return predecessor.getX();
    }

    public int getPredecessorY(){
        return predecessor.getY();
    }

    public int getDistance() {
        return distance;
    }

    public boolean isWall() {
        return isWall;
    }
}
