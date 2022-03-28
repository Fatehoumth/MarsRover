package com.acensi.MarsRover.plateau;

public class Plateau {
    private final int lowerCoordinateX = 0;
    private final int lowerCoordinateY = 0;
    private final int upperCoordinateX;
    private final int upperCoordinateY;

    public Plateau(int upperCoordinateX, int upperCoordinateY){
        this.upperCoordinateX = upperCoordinateX;
        this.upperCoordinateY = upperCoordinateY;
    }

    public int getLowerCoordinateX(){
        return this.lowerCoordinateX;
    }

    public int getLowerCoordinateY(){
        return this.lowerCoordinateY;
    }

    public int getUpperCoordinateX(){
        return this.upperCoordinateX;
    }

    public int getUpperCoordinateY(){
        return this.upperCoordinateY;
    }


}
