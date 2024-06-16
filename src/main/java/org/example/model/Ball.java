package org.example.model;

public class Ball {

    private int runsScored;

    public void setIsWicket(int isWicket) {
        this.isWicket = isWicket;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getIsWicket() {
        return isWicket;
    }

    private int isWicket;
    private Player playedBy;
    private Player bowledBy;


    public int getRunsScored() {
        return runsScored;
    }

    public int isWicket() {
        return isWicket;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }
}
