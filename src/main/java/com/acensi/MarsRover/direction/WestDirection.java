package com.acensi.MarsRover.direction;

import com.acensi.MarsRover.rover.Rover;

public class WestDirection implements Direction{
    @Override
    public Direction spinLeft() {
        return new SouthDirection();
    }

    @Override
    public Direction spinRight() {
        return new NorthDirection();
    }

    @Override
    public boolean isValidPosition(Rover rover){
        return rover.getCoordinateX() > rover.getPlateau().getLowerCoordinateX();
    }

    @Override
    public void moveForward(Rover rover) {
        if(isValidPosition(rover)) {
            rover.setCoordinateX(rover.getCoordinateX() - 1);
        }
        else{
            throw new RuntimeException("the rover's coordinateX is less or equal to the plateau's LowerCoordinateX");
        }
    }

}
