package ru.netology;

import java.util.HashMap;

public class Game {

    private HashMap<String, Player> players = new HashMap<>();

    public Player register(Player player) {
        players.put(player.getName(), player);
        return player;
    }

    public String findByName(String name) {
        for (String player : players.keySet()) {
            if (player.equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player" + playerName2 + " is not registered");
        }

        if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
            return 1;
        } else if (players.get(playerName1).getStrength() < players.get(playerName2).getStrength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
