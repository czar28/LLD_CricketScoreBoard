package org.example;

import org.example.constants.BattingStatus;
import org.example.constants.MatchSTatus;
import org.example.model.CricketMatch;
import org.example.model.CricketTeam;
import org.example.model.Innings;
import org.example.model.Player;
import org.example.model.Ball;
import org.example.service.LineupService;
import org.example.service.ScoreBoardService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        ScoreBoardService scoreBoardService = new ScoreBoardService();
        LineupService lineupService = new LineupService();

        CricketTeam firstTeam = getTeamInput(scanner);
        CricketTeam secondTeam = getTeamInput(scanner);
        Innings firstInnings = new Innings(firstTeam, secondTeam);
        Innings secondInnings = new Innings(secondTeam, firstTeam);
        CricketMatch cricketMatch = new CricketMatch(firstInnings, secondInnings);
        scoreBoardService.displayScore(cricketMatch);
        while(!MatchSTatus.COMPLETED.equals(cricketMatch.getMatchStatus())) {
            getOverInput(scanner, cricketMatch, lineupService);
            scoreBoardService.displayScore(cricketMatch);
        }
    }

    private static void getOverInput(Scanner scanner, CricketMatch cricketMatch, LineupService lineupService) {

        try {
            System.out.println("Input number of balls in the over");
            int numOfBalls = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Input Bowler Name");
            String bowlerName = scanner.nextLine();
            Player bowledBy = lineupService.getBowlerByName(cricketMatch, bowlerName);
            for(int i = 0; i < numOfBalls; i++) {

                Ball ball = new Ball();
                Player onStrikeBatsman = lineupService.getBatsmanByStatus(cricketMatch, BattingStatus.STRIKE);
                if(onStrikeBatsman == null) {
                    onStrikeBatsman = lineupService.getBatsmanByStatus(cricketMatch, BattingStatus.YET_TO_BAT);
                    onStrikeBatsman.setBattingStatus(BattingStatus.STRIKE);
                }
                Player offStrikeBatsman = lineupService.getBatsmanByStatus(cricketMatch, BattingStatus.NON_STRIKE);
                if(offStrikeBatsman == null) {
                    offStrikeBatsman = lineupService.getBatsmanByStatus(cricketMatch, BattingStatus.YET_TO_BAT);
                    offStrikeBatsman.setBattingStatus(BattingStatus.NON_STRIKE);
                }
                String runsScored = scanner.nextLine();
                if("W".equals(runsScored)) {

                    ball.setIsWicket(1);
                    onStrikeBatsman.setBattingStatus(BattingStatus.OUT);
                    Player nextBatsman = lineupService.getBatsmanByStatus(cricketMatch, BattingStatus.YET_TO_BAT);
                    if(nextBatsman == null) {
                        if(cricketMatch.isFirstInnings()) {
                            cricketMatch.setIsFirstInnings(false);
                            System.out.println("All Bowled Out Innings Over");
                        } else {
                            cricketMatch.setMatchStatus(MatchSTatus.COMPLETED);
                            System.out.println("All Bowled Out Match Over");
                        }
                        break;
                    } else {
                        nextBatsman.setBattingStatus(BattingStatus.STRIKE);
                    }

                    bowledBy.bowlBall(ball);
                } else {

                    ball.setRunsScored(Integer.parseInt(runsScored));
                    onStrikeBatsman.playBall(ball);
                    bowledBy.bowlBall(ball);

                    if(Integer.parseInt(runsScored) % 2 == 1) {
                        swapStrike(onStrikeBatsman, offStrikeBatsman);
                    }
                }
                cricketMatch.addDelivery(ball);
                if(i == numOfBalls - 1)
                    swapStrike(onStrikeBatsman, offStrikeBatsman);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }


    }

    private static void swapStrike(Player onStrikeBatsman, Player offStrikeBatsman) {
        onStrikeBatsman.setBattingStatus(BattingStatus.NON_STRIKE);
        offStrikeBatsman.setBattingStatus(BattingStatus.STRIKE);
    }

    private static CricketTeam getTeamInput(Scanner scanner) {

        try {
            System.out.println("Input number of Players in the Team");
            int teamOnePLayers = scanner.nextInt();
            scanner.nextLine();
            assert teamOnePLayers > 2;
            CricketTeam team = new CricketTeam();
            for(int i = 0; i < teamOnePLayers; i++) {
                System.out.println("Enter Details for Player " + (i+1) +"\n");
                String playerName = scanner.nextLine();
                Player player = new Player(playerName);
                player.setBattingStatus(BattingStatus.YET_TO_BAT);
                team.addPlayer(player);
            }
            return team;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}