package com.acensi.MarsRover.rover;

import com.acensi.MarsRover.command.Command;
import com.acensi.MarsRover.direction.Direction;
import com.acensi.MarsRover.plateau.Plateau;

import java.util.ArrayList;

public class Rover {
    private final Plateau plateau;
    private Direction direction;
    private int coordinateX;
    private int coordinateY;

    public Rover(Plateau plateau, Direction direction, int coordinateX, int coordinateY){
        this.plateau = plateau;
        this.direction = direction;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        checkRoverHasValidPosition();
    }

    public Direction getDirection(){
        return this.direction;
    }

    public Plateau getPlateau(){
        return this.plateau;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public int getCoordinateX(){
        return this.coordinateX;
    }

    public void setCoordinateX(int coordinateX){
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY(){
        return this.coordinateY;
    }

    public void setCoordinateY(int coordinateY){
        this.coordinateY = coordinateY;
    }

    public void checkRoverHasValidPosition(){
        if (
                this.getCoordinateX() < this.getPlateau().getLowerCoordinateX() ||
                this.getCoordinateY() < this.getPlateau().getLowerCoordinateY() ||
                this.getCoordinateX() > this.getPlateau().getUpperCoordinateX() ||
                this.getCoordinateY() > this.getPlateau().getUpperCoordinateY()
        ){
            throw new RuntimeException("the rover position can not be out of the plateau");
        }
    }

    public void spinLeft(){
        direction = getDirection().spinLeft();
    }

    public void spinRight(){
        direction = getDirection().spinRight();
    }

    public void moveForward(){
        direction.moveForward(this);
    }

    public void runAllCommands(ArrayList<Command> commands) {
        for (Command command : commands)
            command.action(this);
    }


}
