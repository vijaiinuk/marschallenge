import com.lme.Coordinate;
import com.lme.Robot;
import com.lme.exception.InvalidInputException;
import com.lme.strategies.move.*;
import com.lme.strategies.rotate.RotateLeft;
import com.lme.strategies.rotate.RotateRight;
import com.lme.strategies.rotate.RotationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lme.MarsValidator.checkLost;
import static com.lme.MarsValidator.previouslyLost;
import static java.util.Arrays.asList;

public class RobotOperator {

    private final Map<Character, RotationStrategy> rotationStrategies = new HashMap<>();
    private final Map<Character, ForwardStrategy> forwardStrategies = new HashMap<>();
    private final List<Character> validInputs = asList('L', 'R', 'F');
    private static final List<Coordinate> lostCoordinates = new ArrayList<>();
    private final Coordinate upperbounds;
    private final Coordinate startingPoint = new Coordinate(0, 0);

    public RobotOperator(Coordinate upperbounds) {
        this.upperbounds = upperbounds;

        rotationStrategies.put('L', new RotateLeft());
        rotationStrategies.put('R', new RotateRight());

        forwardStrategies.put('N', new ForwardNorth());
        forwardStrategies.put('E', new ForwardEast());
        forwardStrategies.put('S', new ForwardSouth());
        forwardStrategies.put('W', new ForwardWest());

    }

    public String operate(Robot robot, String instructions) throws InvalidInputException {

//        log.debug("Received robot : "+printRobot(robot)+" instructions: "+instructions);

        char[] commands = instructions.toCharArray();

        for (char command : commands) {
            if(!validInputs.contains(command))
                throw new InvalidInputException(instructions + " contains invalid command (not in L, R, F)");
        }

        for (char command : commands) {
            if(!robot.isLost())  {
                if(rotationStrategies.containsKey(command))
                    rotationStrategies.get(command).rotate(robot);
                else  {
                    forwardStrategies.get(robot.getCurrentDirection()).move(robot);
                    if(previouslyLost(robot, lostCoordinates))  {
//                        log.debug("in previous lost position, moving back to safety!!");
                        robot.moveBackToSafety();
                    }

                    if(checkLost(startingPoint, upperbounds, robot))
                        robot.setLost();
                }
            } else  {
//                log.debug("Robot is Lost!! "+robot);
                lostCoordinates.add(robot.getCurrentPosition());
                break;
            }

//            log.debug(command + " : " + printRobot(robot));

        }

        return printRobot(robot);

    }

    private String printRobot(Robot robot) {
        String output = robot.getX() + " " + robot.getY() + " " + robot.getCurrentDirection() + (robot.isLost() ? (" LOST") : "");
        System.out.println(output);
        return output;
    }
}
