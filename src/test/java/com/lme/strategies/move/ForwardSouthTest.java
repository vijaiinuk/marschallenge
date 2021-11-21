package com.lme.strategies.move;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForwardSouthTest {

    @Test
    public void forward()  {
        ForwardStrategy forwardStrategy = new ForwardSouth();

        Robot robot = new Robot(new Coordinate(), 'S');
        assertEquals(new Robot(new Coordinate(0, -1), 'S'), forwardStrategy.move(robot));

    }

}