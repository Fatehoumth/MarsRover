package com.acensi.MarsRover.command;
import com.acensi.MarsRover.rover.Rover;

public interface Command {
    void action(Rover rover);
}


