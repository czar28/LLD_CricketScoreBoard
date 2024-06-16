package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Innings {

    private int totalRunsScored;
    private int totalWicketsTaken;



    private CricketTeam battingTeam;
    private CricketTeam bowlingTeam;

    public Innings(CricketTeam battingTeam, CricketTeam bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
    }

    public void addDelivery(Ball ball) {
        totalRunsScored += ball.getRunsScored();
        if(ball.isWicket() == 1) {
            totalWicketsTaken += 1;
        }
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }
    public CricketTeam getBattingTeam() {
        return battingTeam;
    }
    public CricketTeam getBowlingTeam() {
        return bowlingTeam;
    }
}
