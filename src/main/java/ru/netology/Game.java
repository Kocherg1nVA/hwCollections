package ru.netology;

import java.util.HashMap;

public class Game {

    private HashMap<String, Player> players = new HashMap<>();

    public Player register(Player player) {
        players.put(player.getName(), player);
        return player;
    }

    public boolean findByName(String name) {

        return players.containsKey(name);
    }

    public int round(String playerName1, String playerName2) {
        
        if (!findByName(playerName1)) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        } else if (!findByName(playerName2)) {
            throw new NotRegisteredException("Player" + playerName2 + " is not registered");
        }

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
