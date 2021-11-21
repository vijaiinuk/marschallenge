package com.lme.strategies.move;

import com.lme.Coordinate;
import com.lme.Robot;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForwardEastTest {

    @Test
    public void forward()  {
        ForwardStrategy forwardStrategy = new ForwardEast();

        Robot robot = new Robot(new Coordinate(), 'E');
        assertEquals(new Robot(new Coordinate(1, 0), 'E'), forwardStrategy.move(robot));

    }

}