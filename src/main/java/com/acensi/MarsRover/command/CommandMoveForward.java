package com.acensi.MarsRover.command;
import com.acensi.MarsRover.rover.Rover;

public class CommandMoveForward implements Command{
    @Override
    public void action(Rover rover) {
        rover.moveForward();
    }
}
