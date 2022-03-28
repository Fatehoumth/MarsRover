package com.acensi.MarsRover.direction;

import com.acensi.MarsRover.rover.Rover;

public interface Direction {

    public Direction spinLeft();

    public Direction spinRight();

    public void moveForward(Rover rover);

    public boolean isValidPosition(Rover rover);





}
