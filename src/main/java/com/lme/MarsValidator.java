package com.lme;

import java.util.List;

public class MarsValidator {

    public static boolean previouslyLost(Robot robot, List<Coordinate> lostCoordinates)  {
        return lostCoordinates.contains(robot.getCurrentPosition());
    }
    public static boolean checkLost(Coordinate min, Coordinate max, Robot robot)  {
        return robot.getX() < min.getX() || robot.getY() < min.getY()
                || robot.getX() > max.getX() || robot.getY() > max.getY();
    }
}
