package com.acensi.MarsRover.command;
import com.acensi.MarsRover.MemberVariableTest;
import com.acensi.MarsRover.direction.EastDirection;
import com.acensi.MarsRover.direction.SouthDirection;
import com.acensi.MarsRover.rover.Rover;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandSpinLeftTest extends MemberVariableTest {

    @BeforeAll
    static public void initStartingTime() {
        startedAt = Instant.now();
    }

    @BeforeEach
    public void init(){
        direction = new SouthDirection();
        rover = new Rover(plateau,direction,coordinateX,coordinateY);
        command = new CommandSpinLeft();
    }

    @Test
    public void whenCommandSpinLeftIsExecutedThenRoverSpinsLeft(){
        command.action(rover);
        assertEquals(EastDirection.class,rover.getDirection().getClass());
    }

    @AfterAll
    static public void showTestDuration() {
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
}
