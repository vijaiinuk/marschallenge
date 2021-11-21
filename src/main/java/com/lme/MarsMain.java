package com.lme;

import com.lme.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarsMain {

    private static final String helpText = "The first line of input is the upper-right coordinates of the rectangular world, the lower-left coordinates are assumed to be 0, 0. \n" +
            "The remaining input consists of a sequence of robot positions and instructions (two lines per robot)." +
            "example 3 lines below: \n" +
            "5 3\n" +
            "1 1 E\n" +
            "RFL";

    private static final List<String> exitStrings = Arrays.asList("exit", "bye", "end");

    public static void main(String[] args) throws InvalidInputException {

        System.out.println("Provide input in 3 lines");
        System.out.println(helpText);
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thirdLine = scanner.nextLine();
        String[] upperbounds = firstLine.split("\\s+");
        String[] initial = secondLine.split("\\s+");


        while(!exitStrings.contains(firstLine) && !exitStrings.contains(secondLine) && !exitStrings.contains(thirdLine))  {

            try  {
                Coordinate max = new Coordinate(Integer.parseInt(upperbounds[0]),
                        Integer.parseInt(upperbounds[1]));

                Coordinate start = new Coordinate(Integer.parseInt(initial[0]),
                        Integer.parseInt(initial[1]));

                RobotOperator operator = new RobotOperator(max);
                operator.operate(new Robot(start, initial[2].charAt(0)), thirdLine);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e)  {
                System.out.println("Provide a valid input as below: \n "+helpText);
            }

            secondLine = scanner.nextLine();
            if(verifyExit(secondLine))
                break;
            thirdLine = scanner.nextLine();
            if(verifyExit(secondLine))
                break;
            upperbounds = firstLine.split("\\s+");
            initial = secondLine.split("\\s+");

        }
    }

    private static boolean verifyExit(String input) {
        return exitStrings.contains(input);
    }
}
