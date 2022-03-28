package com.acensi.MarsRover.input;
import com.acensi.MarsRover.MemberVariableTest;
import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.command.CommandMoveForward;
import com.acensi.MarsRover.command.CommandSpinLeft;
import com.acensi.MarsRover.command.CommandSpinRight;
import com.acensi.MarsRover.direction.NorthDirection;
import com.acensi.MarsRover.plateau.Plateau;
import com.acensi.MarsRover.rover.Rover;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class InputTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @Test
    public void whenGetInputFromFileIsExecutedThenShouldReturnListOfStringInput() throws IOException {
        Path path = Paths.get("/Users/fatehoumitouche/Downloads/MarsRover/src/main/resources/input.txt");
        ArrayList<String> testInputFile = Input.getInputFromFile(path);
        String expectedInputLineOne = "5 5";
        String expectedInputLineTwo = "1 2 N";
        String expectedInputLineThree = "LMLMLMLMM";
        String expectedInputLineFour = "3 3 E";
        String expectedInputLineFive = "MMRMMRMRRM";
        assertTrue(testInputFile.size() == 5);
        assertEquals(expectedInputLineOne, testInputFile.get(0));
        assertEquals(expectedInputLineTwo, testInputFile.get(1));
        assertEquals(expectedInputLineThree, testInputFile.get(2));
        assertEquals(expectedInputLineFour, testInputFile.get(3));
        assertEquals(expectedInputLineFive, testInputFile.get(4));
    }

    @Test
    public void whenGetPlateauFromInputIsExecutedThenShouldCreatePlateau(){
        String inputPlateau = "5 5";
        Plateau plateau = Input.getPlateauFromInput(inputPlateau);
        assertEquals(0,plateau.getLowerCoordinateX());
        assertEquals(0,plateau.getLowerCoordinateY());
        assertEquals(5,plateau.getUpperCoordinateX());
        assertEquals(5,plateau.getUpperCoordinateX());
    }

    @Test
    public void whenGetRoverFromInputIsExecutedThenShouldCreateRover(){
        String inputRover = "1 2 N";
        Rover rover = Input.getRoverFromInput(inputRover,plateau);
        assertEquals(1,rover.getCoordinateX());
        assertEquals(2,rover.getCoordinateY());
        assertEquals(NorthDirection.class,rover.getDirection().getClass());
    }

    @Test
    public void whenGetListCommandFromInputIsExecutedThenShouldCreateListOfCommands(){
        String inputCommand = "LMRMLMRMM";
        ArrayList<Command> listCommand = Input.getListCommandFromInput(inputCommand);
        assertEquals(CommandSpinLeft.class, listCommand.get(0).getClass());
        assertEquals(CommandMoveForward.class, listCommand.get(1).getClass());
        assertEquals(CommandSpinRight.class, listCommand.get(2).getClass());
        assertEquals(CommandMoveForward.class, listCommand.get(3).getClass());
        assertEquals(CommandSpinLeft.class, listCommand.get(4).getClass());
        assertEquals(CommandMoveForward.class, listCommand.get(5).getClass());
        assertEquals(CommandSpinRight.class, listCommand.get(6).getClass());
        assertEquals(CommandMoveForward.class, listCommand.get(7).getClass());
        assertEquals(CommandMoveForward.class, listCommand.get(8).getClass());
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
