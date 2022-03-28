package com.acensi.MarsRover;

import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.direction.Direction;
import com.acensi.MarsRover.plateau.Plateau;
import com.acensi.MarsRover.rover.Rover;

import java.time.Instant;
import java.time.temporal.Temporal;

public class MemberVariableTest {
    protected static Temporal startedAt;

    protected final Plateau plateau = new Plateau(5, 5);
    protected Direction direction;
    protected int coordinateX = 3;
    protected int coordinateY = 3;
    protected Rover rover;
    protected Command command;

}
