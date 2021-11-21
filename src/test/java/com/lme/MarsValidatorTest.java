package com.lme;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class MarsValidatorTest {

    @Test
    public void checkLost() {
        assertTrue(MarsValidator.previouslyLost(new Robot(new Coordinate(4, 5), 'E'), Collections.singletonList(new Coordinate(4, 5))));
        assertFalse(MarsValidator.previouslyLost(new Robot(new Coordinate(4, 5), 'E'), Collections.singletonList(new Coordinate(5, 5))));

        assertFalse(MarsValidator.previouslyLost(new Robot(new Coordinate(4, 5), 'E'), Collections.emptyList()));


    }

    @Test
    public void validateInGrid() {

        assertFalse(MarsValidator.checkLost(new Coordinate(), new Coordinate(), new Robot(new Coordinate(0, 0))));

        assertFalse(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(1, 1))));

        assertFalse(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(5, 10))));

        assertFalse(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(0, 0))));

        assertTrue(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(-1, 0))));

        assertTrue(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(0, -1))));

        assertTrue(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(6, 1))));

        assertTrue(MarsValidator.checkLost(new Coordinate(), new Coordinate(5,10), new Robot(new Coordinate(5, 11))));


    }
}