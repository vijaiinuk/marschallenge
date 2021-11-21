package com.lme.strategies.move;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForwardWestTest {

    @Test
    public void forward()  {
        ForwardStrategy forwardStrategy = new ForwardWest();

        Robot robot = new Robot(new Coordinate(), 'W');
        assertEquals(new Robot(new Coordinate(-1, 0), 'W'), forwardStrategy.move(robot));

    }

}