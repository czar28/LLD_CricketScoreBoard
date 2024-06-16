package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Ball;


public class  Over {

    private int overNumber;
    private List<Ball> balls;

    public Over(int overNumber) {
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
    }
    public void addBall(Ball ball) {
        this.balls.add(ball);
    }
}
