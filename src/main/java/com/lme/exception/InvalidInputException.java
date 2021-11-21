package com.lme.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException()  {

    }
    public InvalidInputException(String s) {
        System.out.println("Invalid Input Exception: "+s);
    }
}
