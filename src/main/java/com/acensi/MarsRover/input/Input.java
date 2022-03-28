package com.acensi.MarsRover.input;
import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.command.CommandShortened;
import com.acensi.MarsRover.direction.Direction;
import com.acensi.MarsRover.direction.DirectionShortened;
import com.acensi.MarsRover.plateau.Plateau;
import com.acensi.MarsRover.rover.Rover;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Input {

    public static ArrayList<String> getInputFromFile(Path path) throws IOException {
        ArrayList<String> inputFile = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            inputFile.add(line);
        }
        return inputFile;
    }

    public static Plateau getPlateauFromInput(String inputPlateau){
        String[] coordinates = inputPlateau.split(" ");
        int upperCoordinateX = Integer.parseInt(coordinates[0]);
        int upperCoordinateY = Integer.parseInt(coordinates[1]);
        return new Plateau(upperCoordinateX,upperCoordinateY);
    }

    public static Rover getRoverFromInput(String coordinateAndDirectionInput, Plateau plateau){
        String[] coordinates = coordinateAndDirectionInput.split(" ");
        int roverCoordinateX = Integer.parseInt(coordinates[0]);
        int roverCoordinateY = Integer.parseInt(coordinates[1]);
        Direction direction = DirectionShortened.valueOf(coordinates[2]).getDirection();
        return new Rover(plateau,direction,roverCoordinateX,roverCoordinateY);
    }

    public static ArrayList<Command> getListCommandFromInput(String commandInput){
        char[] commandArray = commandInput.toCharArray();
        ArrayList<Command> commandList = new ArrayList<>();
        for(char commandShortened : commandArray){
            commandList.add(CommandShortened.valueOf(Character.toString(commandShortened)).getCommand());
        }
        return commandList;
    }


}
