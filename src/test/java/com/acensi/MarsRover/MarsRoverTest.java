package com.acensi.MarsRover;

import com.acensi.MarsRover.command.*;
import com.acensi.MarsRover.direction.EastDirectionTest;
import com.acensi.MarsRover.direction.NorthDirectionTest;
import com.acensi.MarsRover.direction.SouthDirectionTest;
import com.acensi.MarsRover.direction.WestDirectionTest;
import com.acensi.MarsRover.input.InputTest;
import com.acensi.MarsRover.plateau.PlateauTest;
import com.acensi.MarsRover.rover.RoverTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

    @Suite
    @SuiteDisplayName("MarsRover Test")
    @SelectClasses( { CommandMoveForwardTest.class, CommandSpinRightTest.class, CommandSpinLeftTest.class,
            EastDirectionTest.class, NorthDirectionTest.class, SouthDirectionTest.class, WestDirectionTest.class,
            InputTest.class, PlateauTest.class, RoverTest.class,} )
    public class MarsRoverTest
    {
    }

