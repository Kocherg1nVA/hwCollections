package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Brut", 16);
    Player player2 = new Player(12, "Lion", 18);
    Player player3 = new Player(8, "Ozzy", 11);
    Player player4 = new Player(3, "Zoltan", 16);

    Game manager = new Game();

    @Test
    public void shouldAddPlayer() {

        Assertions.assertEquals(player1, manager.register(player1));
    }

    @Test
    public void shouldFindByName() {

        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        Player expected = player2;
        Player actual = manager.findByName("Lion");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        Player expected = null;
        Player actual = manager.findByName("Zoltan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Wins() {
        manager.register(player1);
        manager.register(player2);

        int expected = -1;
        int actual = manager.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1Wins() {
        manager.register(player1);
        manager.register(player3);

        int expected = 1;
        int actual = manager.round(player1.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        manager.register(player1);
        manager.register(player4);

        int expected = 0;
        int actual = manager.round(player1.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowWhenPlayer1NotRegistered() {
        manager.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    manager.round(player1.getName(), player2.getName());
                });
    }

    @Test
    public void shouldThrowWhenPlayer2NotRegistered() {
        manager.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    manager.round(player1.getName(), player2.getName());
                });
    }

    @Test
    public void shouldThrowWhenAllPlayersIsNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    manager.round(player3.getName(), player4.getName());
                });
    }
}
