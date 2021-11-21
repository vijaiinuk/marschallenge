package com.lme.strategies.move;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForwardNorthTest {

    @Test
    public void forward()  {
        ForwardStrategy forwardStrategy = new ForwardNorth();

        Robot robot = new Robot(new Coordinate(), 'N');
        assertEquals(new Robot(new Coordinate(0, 1), 'N'), forwardStrategy.move(robot));

    }

}