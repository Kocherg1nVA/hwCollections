package ru.netology;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public Player register(Player player) {
        players.add(player);
        return player;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        } else if (player2 == null) {
            throw new NotRegisteredException("Player" + playerName2 + " is not registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
