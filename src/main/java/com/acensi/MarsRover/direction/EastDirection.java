package com.acensi.MarsRover.direction;

import com.acensi.MarsRover.rover.Rover;

public class EastDirection implements Direction{
    @Override
    public Direction spinLeft() {
        return new NorthDirection();
    }

    @Override
    public Direction spinRight() {
        return new SouthDirection();
    }

    @Override
    public boolean isValidPosition(Rover rover){
        return rover.getCoordinateX() < rover.getPlateau().getUpperCoordinateX();
    }

    @Override
    public void moveForward(Rover rover) {
        if(isValidPosition(rover)){
            rover.setCoordinateX(rover.getCoordinateX()+1);
        }
        else{
            throw new RuntimeException("the rover's coordinateX is greater than or equal to the plateau's UpperCoordinateX");
        }
    }
}
