package com.acensi.MarsRover.direction;

import com.acensi.MarsRover.rover.Rover;

public class NorthDirection implements Direction{
    @Override
    public Direction spinLeft() {
        return new WestDirection();
    }

    @Override
    public Direction spinRight() {
        return new EastDirection();
    }

    @Override
    public boolean isValidPosition(Rover rover){
        return rover.getCoordinateY() < rover.getPlateau().getUpperCoordinateY();
    }

    @Override
    public void moveForward(Rover rover) {
        if(isValidPosition(rover)){
            rover.setCoordinateY(rover.getCoordinateY()+1);
        }
        else{
            throw new RuntimeException("the rover's coordinateY is greater than or equal to the plateau's UpperCoordinateY");
        }
    }
}
