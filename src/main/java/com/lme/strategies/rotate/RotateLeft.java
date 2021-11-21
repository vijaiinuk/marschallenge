package com.lme.strategies.rotate;

import com.lme.Robot;

public class RotateLeft implements RotationStrategy {
    @Override
    public Robot rotate(Robot robot) {
        robot.rotateAntiClockwise();
        return robot;
    }
}
