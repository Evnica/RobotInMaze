package com.evnica.maze;

import java.io.IOException;

/**
 * Class: MazeIODemo
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class MazeIODemo
{
    public static void main( String[] args ) throws IOException
    {
        Maze maze = MazeIO.loadMaze( "D:\\1-GI\\MSc\\CompSc\\t20.maz" );
        char[][] mazeStructure = maze.mazeStructure;
        System.out.println(MazeIO.composeSolutionString( mazeStructure ));
        System.out.println(maze.start);
        System.out.println(maze.goal);

    }
}
