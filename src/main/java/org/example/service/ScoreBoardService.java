package org.example.service;

import org.example.model.CricketMatch;
import org.example.model.CricketTeam;
import org.example.model.Innings;

public class ScoreBoardService {


    public void displayScore(CricketMatch cricketMatch) {
        System.out.println("-------------SCORE----------------------");
        if(cricketMatch == null)
            throw new IllegalArgumentException("No Cricket Match Present");
        if(cricketMatch.isFirstInnings()) {
            System.out.println("The First Innings Score is " + cricketMatch.getFirstInnings().getTotalRunsScored() + " "+ cricketMatch.getFirstInnings().getTotalWicketsTaken() + "\n");
            displayInningsScoreBoard(cricketMatch.getFirstInnings());
        } else {
            System.out.println("The Second Innings Score is " + cricketMatch.getSecondInnings().getTotalRunsScored() + " "+ cricketMatch.getSecondInnings().getTotalWicketsTaken() + "\n");
            displayInningsScoreBoard(cricketMatch.getSecondInnings());
        }
        System.out.println("----------------------------------------");

    }

    private static void displayInningsScoreBoard(Innings innings) {

        displayTeamScore(innings.getBattingTeam(), true);
        displayTeamScore(innings.getBowlingTeam(), false);
    }

    private static void displayTeamScore(CricketTeam cricketTeam, boolean isBattingTeam) {
        if (isBattingTeam) {
            System.out.println("Batting \n");
            cricketTeam.getPlayers()
                    .stream()
                    .forEach(player -> System.out.println(player.getName() + " " + player.getTotalRunsScored() + " " + player.getFours() + " " + player.getSixes() + "\n"));
        } else {
            System.out.println("Bowling \n");
            cricketTeam.getPlayers()
                    .stream()
                    .forEach(player -> System.out.println(player.getName() + " " + player.getRunsGiven() + "/" + player.getWicketsTaken() + "\n"));

        }
    }
}
