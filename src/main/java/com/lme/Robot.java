package com.lme;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayDeque;

import static java.util.Arrays.asList;

@EqualsAndHashCode
@ToString
public class Robot {


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Coordinate currentPosition = new Coordinate(0,0);
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final Coordinate previousPosition = new Coordinate(0, 0);

    private boolean isLost = false;


    @EqualsAndHashCode.Exclude
    private final ArrayDeque<Character> directions = new ArrayDeque<Character>(asList('N', 'E', 'S', 'W'));

    public Robot()  {
        this.currentPosition = new Coordinate(0,0);
        setOrientation('N');
    }

    public Robot(Character orientation)  {
        this.currentPosition = new Coordinate(0,0);
        setOrientation(orientation);
    }

    public Robot(Coordinate initial)  {
        this.currentPosition = initial;
        setOrientation('N');
    }

    public Robot(Coordinate initial, Character orientation) {
        this.currentPosition = initial;
        setOrientation(orientation);
    }

    private void setOrientation(char orientation) {
        while (directions.peek() != orientation)  {
            directions.addLast(directions.pollFirst());
        }
    }

    @ToString.Include
    @EqualsAndHashCode.Include
    public int getX() {
        return isLost ? previousPosition.getX() : currentPosition.getX();
    }

    @ToString.Include
    @EqualsAndHashCode.Include
    public int getY() {
        return isLost ? previousPosition.getY() : currentPosition.getY();
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost() {
        isLost = true;
    }

    public Coordinate getCurrentPosition() {
        return currentPosition;
    }

    public Coordinate getPreviousPosition() {
        return previousPosition;
    }

    public void moveBackToSafety()  {
        this.currentPosition = this.previousPosition;
    }

    public void incrementX()  {
        copyPositions(currentPosition, previousPosition);
        currentPosition.incrementX();
    }

    private void copyPositions(Coordinate current, Coordinate previous) {
        previous.setX(current.getX());
        previous.setY(current.getY());
    }

    public void decrementX()  {
        copyPositions(currentPosition, previousPosition);
        currentPosition.decrementX();
    }

    public void incrementY()  {
        copyPositions(currentPosition, previousPosition);
        currentPosition.incrementY();
    }

    public void decrementY()  {
        copyPositions(currentPosition, previousPosition);
        currentPosition.decrementY();
    }

    @ToString.Include
    @EqualsAndHashCode.Include
    public char getCurrentDirection()  {
        return directions.peekFirst();
    }

    public void rotateClockwise()  {
        directions.addLast(directions.pollFirst());
    }

    public void rotateAntiClockwise()  {
        directions.addFirst(directions.pollLast());
    }


}
