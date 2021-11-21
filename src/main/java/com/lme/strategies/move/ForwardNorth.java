package com.lme.strategies.move;

import com.lme.Robot;

public class ForwardNorth implements ForwardStrategy {
    @Override
    public Robot move(Robot robot) {
        robot.incrementY();
        return robot;
    }
}
