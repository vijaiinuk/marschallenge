package com.lme;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Coordinate {
    private int x;
    private int y;

    public Coordinate()  {
        x = 0;
        y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementX()  {
        x++;
    }

    public void decrementX()  {
        x--;
    }

    public void incrementY()  {
        y++;
    }

    public void decrementY()  {
        y--;
    }

}
