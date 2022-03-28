package com.acensi.MarsRover;
import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.input.Input;
import com.acensi.MarsRover.plateau.Plateau;
import com.acensi.MarsRover.rover.Rover;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/fatehoumitouche/Downloads/MarsRover/src/main/resources/input.txt");
        ArrayList<String> fileInput = Input.getInputFromFile(path);
        String plateauCoordinate = fileInput.get(0);
        Plateau plateau = Input.getPlateauFromInput(plateauCoordinate);
        List<String> informationInput = fileInput.subList(1, fileInput.size());

        System.out.println("Input:" + "\n");
        for (String input : fileInput)
            System.out.println(input);

        System.out.println("\n" + "Output:" + "\n");
        for (int i = 0; i < informationInput.size(); i += 2) {
            Rover rover = Input.getRoverFromInput(informationInput.get(i), plateau);
            ArrayList<Command> commands = Input.getListCommandFromInput(informationInput.get(i + 1));
            rover.runAllCommands(commands);
            System.out.println(rover.getCoordinateX() + " " + rover.getCoordinateY() + " " + rover.getDirection().getClass().getSimpleName().charAt(0));
        }
    }
}
