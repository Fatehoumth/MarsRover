package com.acensi.MarsRover.direction;

import com.acensi.MarsRover.rover.Rover;

public class SouthDirection implements Direction{
    @Override
    public Direction spinLeft() {
        return new EastDirection();
    }

    @Override
    public Direction spinRight() {
        return new WestDirection();
    }

    public boolean isValidPosition(Rover rover){
        return rover.getCoordinateY() > rover.getPlateau().getLowerCoordinateY();
    }

    @Override
    public void moveForward(Rover rover) {
        if(isValidPosition(rover)){
            rover.setCoordinateY(rover.getCoordinateY() - 1);
        }
        else{
            throw new RuntimeException("the rover's coordinateY is less or equal to the plateau's LowerCoordinateY");
        }
    }
}
