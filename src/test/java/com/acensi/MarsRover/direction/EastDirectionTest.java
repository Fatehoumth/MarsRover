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

public class EastDirectionTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void init(){
        direction = new EastDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
    }

    @Test
    public void whenEastDirectionSpinRightNewDirectionIsSouthDirection(){
        assertEquals(SouthDirection.class,direction.spinRight().getClass());
    }

    @Test
    public void whenEastDirectionSpinLeftNewDirectionIsNorthDirection(){
        assertEquals(NorthDirection.class,direction.spinLeft().getClass());
    }

    @Test
    public void whenEastDirectionMovesForwardCoordinateXIncrements(){
        direction.moveForward(rover);
        assertEquals(coordinateX+1,rover.getCoordinateX());
    }

    @Test
    public void whenRoversCoordinateXIsGreaterThanOrEqualsPlateausUpperCoordinateXThenIsValidPositionShouldReturnFalse(){
        rover.setCoordinateX(6);
        assertFalse(direction.isValidPosition(rover));
    }

    @Test
    public void whenRoversCoordinateXIsLessThanPlateausUpperCoordinateXThenIsValidPositionShouldReturnTrue(){
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        assertTrue(direction.isValidPosition(rover));
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
