package org.example.service;

import org.example.constants.BattingStatus;
import org.example.model.CricketMatch;
import org.example.model.Innings;
import org.example.model.Player;

public class LineupService {

    public Player getBatsmanByStatus(CricketMatch cricketMatch, BattingStatus battingStatus) {
        Innings innings = cricketMatch.getFirstInnings();
        if(!cricketMatch.isFirstInnings())
            innings = cricketMatch.getSecondInnings();
        return innings.getBattingTeam()
                .getPlayers()
                .stream()
                .filter(player -> battingStatus.equals(player.getBattingStatus()))
                .findAny()
                .orElse(null);

    }

    public Player getBowlerByName(CricketMatch cricketMatch, String bowlerName) {
        Innings innings = cricketMatch.getFirstInnings();
        if(!cricketMatch.isFirstInnings())
            innings = cricketMatch.getSecondInnings();
        return innings.getBowlingTeam()
                .getPlayers()
                .stream()
                .filter(player -> bowlerName.equals(player.getName()))
                .findFirst()
                .get();
    }
}
