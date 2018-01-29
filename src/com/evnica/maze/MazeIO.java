package com.evnica.maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class: MazeIO
 * Version: 0.1
 * Created on 29.01.2018 with the help of IntelliJ IDEA (thanks!)
 * Author: Evnica
 * Description:
 */
public class MazeIO
{
    public static Maze loadMaze(String path) throws IOException {
        Maze maze = null;
        String text = new String( Files.readAllBytes( Paths.get(path)));
        String[] lines = text.split( "\r\n" );
        Location start = null,
                goal = null;
        int side = Integer.parseInt( lines[0] );
        char[][] mazeStructure = new char[side][side];
        for (int j = 1; j < lines.length; j++){
            if (start == null){
                int indexOfStart = lines[j].indexOf( 'S' );
                if (indexOfStart != -1){
                    start = new Location( j-1, indexOfStart );
                }
            }
            if (goal == null){
                int indexOfGoal = lines[j].indexOf( 'G' );
                if (indexOfGoal != -1){
                    goal = new Location( j-1, indexOfGoal );
                }
            }
            mazeStructure[j - 1] = lines[j].toCharArray();
        }

        if (start != null && goal != null){
            maze = new Maze( mazeStructure, start, goal );
        }

        return maze;
    }

    public static String composeSolutionString(char[][] mazeStructure){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mazeStructure[0]);
        for (int i = 1; i < mazeStructure.length; i++){
            stringBuffer.append( "\n" );
            stringBuffer.append(mazeStructure[i]);
        }
        return stringBuffer.toString();
    }

    public static void writeSolvedMaze(char[][] solution, String path) throws IOException {
        String content = composeSolutionString( solution );
        Files.write(Paths.get( path ), content.getBytes());
    }

}
