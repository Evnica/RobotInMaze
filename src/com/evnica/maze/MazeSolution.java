package com.evnica.maze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class: MazeSolution
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class MazeSolution
{
    private static Maze maze;
    private static boolean goalFound = false;
    private static LinkedList<Node> nodesToProcess = new LinkedList<>();

    public static void main( String[] args )
    {

        String path; // "D:\\1-GI\\MSc\\CompSc\\t20f.maz
        Scanner scanner = new Scanner( System.in );
        System.out.println("Please input the path to the file containing maze structure: ");
        path = scanner.next();
        try
        {
            System.out.println("Loading maze...");
            maze = MazeIO.loadMaze( path );
            System.out.println("Maze loaded from file " + path);

            nodesToProcess.add( new Node( null, maze.start, 0 ) );

            while ( ! nodesToProcess.isEmpty() && ! goalFound )
            {
                Node current = nodesToProcess.poll();
                // check North
                assessNeighbor( current, current.getX(), current.getY() - 1 );
                // check East
                assessNeighbor( current, current.getX() + 1, current.getY() );
                // check South
                assessNeighbor( current, current.getX(), current.getY() +1 );
                // check West
                assessNeighbor( current, current.getX() - 1, current.getY() );
            }

            if (goalFound){
                List<Location> pathToGoal = new ArrayList<>();
                Location previous = maze.getPredecessorLocation( maze.goal );
                while ( ! previous.equals( maze.start ) )
                {
                    pathToGoal.add( previous );
                    previous = maze.getPredecessorLocation( previous );
                }
                for (Location step: pathToGoal){
                    maze.mazeStructure[step.getX()][step.getY()] = '*';
                }
                System.out.println("Found path:");
                pathToGoal.forEach( System.out::print );
                System.out.println("\nPath length: " + (pathToGoal.size() + 1));
                System.out.println("Solution: ");
                System.out.println(MazeIO.composeSolutionString( maze.mazeStructure ));
            }
            else{
                System.out.println("Goal cannot be reached");
            }


        } catch ( IOException e )
        {
            System.out.println("File cannot be read. Program terminated");
            e.printStackTrace();
        }
    }

    private static void assessNeighbor(Node current, int x, int y){
        if ( maze.contains( x, y ) ){
            // if there is no predecessor, than the node was not visited before
            if( maze.predecessorStorage[x][y] == null ){
                if (maze.mazeStructure[x][y] == '#'){
                    maze.predecessorStorage[x][y] = new Node( true );
                }
                else {
                    maze.predecessorStorage[x][y] = current;
                    if ( maze.isGoal( x, y ) ){
                        goalFound = true;
                    }
                    else{
                        nodesToProcess.add( new Node( x, y, current.getDistance() + 1 ) );
                    }
                }
            }
        }
    }
}
