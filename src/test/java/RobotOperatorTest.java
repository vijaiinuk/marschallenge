import com.lme.Coordinate;
import com.lme.Robot;
import com.lme.exception.InvalidInputException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotOperatorTest {

    @Test
    public void test_robot_valid_move() throws InvalidInputException {
        Robot robot = new Robot(new Coordinate(0, 0), 'W');
        RobotOperator operator = new RobotOperator(new Coordinate(5, 3));

        assertEquals("0 1 N", operator.operate(robot, "RF"));
    }

    @Test
    public void test_robot_valid_input1() throws InvalidInputException {
        Robot robot = new Robot(new Coordinate(1, 1), 'E');
        RobotOperator operator = new RobotOperator(new Coordinate(5, 3));

        assertEquals("1 1 E", operator.operate(robot, "RFRFRFRF"));

        assertEquals("3 3 N LOST", operator.operate(new Robot(new Coordinate(3,2),'N'), "FRRFLLFFRRFLL"));

        assertEquals("2 3 S", operator.operate(new Robot(new Coordinate(0,3),'W'), "LLFFFLFLFL"));


    }

}