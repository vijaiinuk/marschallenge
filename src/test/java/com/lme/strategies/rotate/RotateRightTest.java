package com.lme.strategies.rotate;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateRightTest {

    @Test
    public void rotate()  {
        RotateRight strategy = new RotateRight();
        Robot robot = new Robot(new Coordinate(0, 0), 'N');
        assertEquals(new Robot(new Coordinate(), 'E'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'S'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'W'), strategy.rotate(robot));

        assertEquals(new Robot(new Coordinate(), 'N'), strategy.rotate(robot));

    }

}