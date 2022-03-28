package com.acensi.MarsRover.command;
import com.acensi.MarsRover.MemberVariableTest;
import com.acensi.MarsRover.direction.*;
import com.acensi.MarsRover.rover.Rover;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandMoveForwardTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void init(){
        command = new CommandMoveForward();
    }

    @Test
    public void whenCommandMoveForwardIsExecutedAndRoverDirectionIsNorthThenCoordinateYIncrements(){
        direction = new NorthDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        command.action(rover);
        assertEquals(coordinateY+1,rover.getCoordinateY());
    }

    @Test
    public void whenCommandMoveForwardIsExecutedAndRoverDirectionIsSouthThenCoordinateYDecrements(){
        direction = new SouthDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        command.action(rover);
        assertEquals(coordinateY-1,rover.getCoordinateY());
    }

    @Test
    public void whenCommandMoveForwardIsExecutedAndRoverDirectionIsEastThenCoordinateXIncrements(){
        direction = new EastDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        command.action(rover);
        assertEquals(coordinateX+1,rover.getCoordinateX());
    }

    @Test
    public void whenCommandMoveForwardIsExecutedAndRoverDirectionIsWestThenCoordinateXDecrements(){
        direction = new WestDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        command.action(rover);
        assertEquals(coordinateX-1,rover.getCoordinateX());
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
