package com.acensi.MarsRover.direction;
import com.acensi.MarsRover.MemberVariableTest;
import com.acensi.MarsRover.rover.Rover;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class NorthDirectionTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void init(){
        direction = new NorthDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
    }

    @Test
    public void whenNorthDirectionSpinLeftThenNewDirectionIsWestDirection(){
        assertEquals(WestDirection.class,direction.spinLeft().getClass());
    }

    @Test
    public void whenNorthDirectionSpinRightThenNewDirectionIsEastDirection(){
        assertEquals(EastDirection.class,direction.spinRight().getClass());
    }

    @Test
    public void whenNorthDirectionMovesForwardCoordinateYIncrements(){
        direction.moveForward(rover);
        assertEquals(coordinateY+1,rover.getCoordinateY());
    }

    @Test
    public void whenRoversCoordinateYIsGreaterThanOrEqualsPlateausUpperCoordinateYThenIsValidPositionShouldReturnFalse(){
        rover.setCoordinateY(6);
        assertFalse(direction.isValidPosition(rover));
    }

    @Test
    public void whenRoversCoordinateYIsLessThanPlateausUpperCoordinateYThenIsValidPositionShouldReturnTrue(){
        assertTrue(direction.isValidPosition(rover));
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
