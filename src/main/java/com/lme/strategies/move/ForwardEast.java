package com.lme.strategies.move;

import com.lme.Robot;

public class ForwardEast implements ForwardStrategy {
    @Override
    public Robot move(Robot robot) {
        robot.incrementX();
        return robot;
    }
}
