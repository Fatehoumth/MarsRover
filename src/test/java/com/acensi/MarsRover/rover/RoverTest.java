package com.acensi.MarsRover.rover;
import com.acensi.MarsRover.MemberVariableTest;
import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.command.CommandMoveForward;
import com.acensi.MarsRover.command.CommandSpinLeft;
import com.acensi.MarsRover.direction.EastDirection;
import com.acensi.MarsRover.direction.SouthDirection;
import com.acensi.MarsRover.direction.WestDirection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RoverTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void setUp(){
        direction = new SouthDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
    }

    @Test
    public void whenRoverSpinLeftThenRoverDirectionSpinLeft(){
        rover.spinLeft();
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRoverSpinRightThenRoverDirectionSpinRight(){
        rover.spinRight();
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRoverMoveForwardThenRoverCoordinateYDecrements(){
        rover.moveForward();
        assertEquals(coordinateY-1,rover.getCoordinateY());
    }

    @Test
    public void whenListCommandAreLMLMLM_ThenRunAllCommandsShouldReturn_4_4_W() throws Exception {
        ArrayList<Command> listCommand = new ArrayList<>();
        listCommand.add(new CommandSpinLeft());
        listCommand.add(new CommandMoveForward());
        listCommand.add(new CommandSpinLeft());
        listCommand.add(new CommandMoveForward());
        listCommand.add(new CommandSpinLeft());
        rover.runAllCommands(listCommand);
        assertEquals(4, rover.getCoordinateX());
        assertEquals(4, rover.getCoordinateY());
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRoverIsCreatedOutOfPlateauThenRuntimeExceptionIsThrown() {
        int new_coordinateX = 6;
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Rover rover = new Rover(plateau,direction,new_coordinateX,coordinateY);
        });
        String expectedMessage = "the rover position can not be out of the plateau";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
