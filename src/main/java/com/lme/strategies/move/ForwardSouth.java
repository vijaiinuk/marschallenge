package com.lme.strategies.move;

import com.lme.Robot;

public class ForwardSouth implements ForwardStrategy {
    @Override
    public Robot move(Robot robot) {
        robot.decrementY();
        return robot;
    }
}
