package com.lme.strategies.rotate;

import com.lme.Robot;

public class RotateRight implements RotationStrategy {
    @Override
    public Robot rotate(Robot robot) {
        robot.rotateClockwise();
        return robot;
    }
}
