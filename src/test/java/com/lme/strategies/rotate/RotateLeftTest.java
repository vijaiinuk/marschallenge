package com.lme.strategies.rotate;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateLeftTest {

    @Test
    public void rotate()  {
        RotateLeft strategy = new RotateLeft();
        Robot robot = new Robot(new Coordinate(0, 0), 'N');
        assertEquals(new Robot(new Coordinate(), 'W'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'S'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'E'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'N'), strategy.rotate(robot));

    }

}