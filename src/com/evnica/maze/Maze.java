package com.evnica.maze;

/**
 * Class: Maze
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class Maze
{
    int side;
    char[][] mazeStructure;
    Node[][] predecessorStorage;
    Location start;
    Location goal;

    public Maze( char[][] mazeStructure, Location start, Location goal )
    {
        this.side = mazeStructure.length;
        this.mazeStructure = mazeStructure;
        this.start = start;
        this.goal = goal;
        predecessorStorage = new Node[side][side];
    }

    public int getSide(){
        return side;
    }

    public int getDistanceToPredecessor(Location nodeLocation){
        return predecessorStorage[nodeLocation.getX()][nodeLocation.getY()].getDistance();
    }

    public boolean isGoal(int x, int y){
        return goal.equals( x, y );
    }

    public boolean isStart(int x, int y){
        return start.equals( x, y );
    }

    public Location getPredecessorLocation(Location nodeLocation){
        return new Location( predecessorStorage[nodeLocation.getX()][nodeLocation.getY()].getX(),
                predecessorStorage[nodeLocation.getX()][nodeLocation.getY()].getY());
    }

    public boolean contains(int x, int y){
        return x >= 0 && x < side && y >= 0 & y < side;
    }



}
