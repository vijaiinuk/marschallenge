package com.lme.strategies.move;

import com.lme.Robot;

public class ForwardWest implements ForwardStrategy {
    @Override
    public Robot move(Robot robot) {
        robot.decrementX();
        return robot;
    }
}
