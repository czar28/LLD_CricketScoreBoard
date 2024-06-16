package org.example.model;

import org.example.constants.BattingStatus;

import java.time.LocalDate;

public class Player {



    private String name;
    private int playerId;
    private LocalDate dateOfBirth;
    private int totalRunsScored;
    private int wicketsTaken;

    public BattingStatus getBattingStatus() {
        return battingStatus;
    }

    public void setBattingStatus(BattingStatus battingStatus) {
        this.battingStatus = battingStatus;
    }

    private BattingStatus battingStatus;

    public Player(String name) {
        this.name = name;
        this.totalRunsScored = 0;
        this.wicketsTaken = 0;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    private int runsGiven;
    private int fours;
    private int sixes;

    public void addTotalRunsScored(int runs) {
        this.totalRunsScored += runs;
    }

    public void addRunsGiven(int runsGiven) {
        this.runsGiven += runsGiven;
    }

    public void addWciketsTaken(int wicketsTaken) {
        this.wicketsTaken += wicketsTaken;
    }

    public void addFours(int fours) {
        this.fours += fours;
    }
    public void addSixes(int sixes) {
        this.sixes += sixes;
    }

    public String getName() {
        return name;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void playBall(Ball ball) {
        this.addTotalRunsScored(ball.getRunsScored());
        if(ball.getRunsScored() == 6)
            this.addSixes(1);
        if(ball.getRunsScored() == 4)
            this.addFours(1);
    }

    public void bowlBall(Ball ball) {
        this.addWciketsTaken(ball.isWicket());
        this.addRunsGiven(ball.getRunsScored());
    }
}
