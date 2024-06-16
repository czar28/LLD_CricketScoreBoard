package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class CricketTeam {
    private List<Player> players;

    public CricketTeam() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
}
