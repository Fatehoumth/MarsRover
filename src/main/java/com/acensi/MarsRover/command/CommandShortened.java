package com.acensi.MarsRover.command;

public enum CommandShortened {
    L(new CommandSpinLeft()),
    R(new CommandSpinRight()),
    M(new CommandMoveForward());

    private Command command;

    CommandShortened(Command command) {
        this.command = command;
    }

    public Command getCommand(){
        return this.command;
    }
}
