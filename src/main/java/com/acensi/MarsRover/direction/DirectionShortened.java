package com.acensi.MarsRover.direction;

public enum DirectionShortened {

    S(new SouthDirection()),
    N(new NorthDirection()),
    W(new WestDirection()),
    E(new EastDirection());

    private final Direction direction;

    DirectionShortened(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection(){
        return this.direction;
    }
}
