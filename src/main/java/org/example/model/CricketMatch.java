package org.example.model;

import org.example.constants.MatchSTatus;

public class CricketMatch {




    private Innings firstInnings;
    private Innings secondInnings;

    public boolean isFirstInnings() {
        return isFirstInnings;
    }

    private boolean isFirstInnings;

    public void setMatchStatus(MatchSTatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    private MatchSTatus matchStatus;

    public CricketMatch(Innings firstInnings, Innings secondInnings) {
        this.isFirstInnings = true;
        this.firstInnings = firstInnings;
        this.secondInnings = secondInnings;
    }

    public void addDelivery(Ball ball) {
        if(Boolean.TRUE.equals(isFirstInnings)) {
            firstInnings.addDelivery(ball);
        } else {
            secondInnings.addDelivery(ball);
            if(secondInnings.getTotalRunsScored() > firstInnings.getTotalRunsScored()) {
                this.matchStatus = MatchSTatus.COMPLETED;

            }
        }
    }

    public void setIsFirstInnings(boolean firstInnings) {
        isFirstInnings = firstInnings;
    }

    public void setSecondInnings(Innings secondInnings) {
        this.secondInnings = secondInnings;
    }

    public MatchSTatus getMatchStatus() {
        return matchStatus;
    }

    public Innings getFirstInnings() {
        return firstInnings;
    }

    public Innings getSecondInnings() {
        return secondInnings;
    }

}
