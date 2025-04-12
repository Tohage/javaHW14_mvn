
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GameTest {

    Player player = new Player(1, "Anya", 5);
    Player player1 = new Player(2, "Vita", 2);
    Player player2 = new Player(3, "Ira", 3);
    Player player3 = new Player(4, "Lena", 7);
    Player player4 = new Player(5, "Tanya", 10);
    Player player5 = new Player(6, "Sasha", 2);

    private Game game = new Game();

    @Test
    public void findName (){
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.findByName("Sasha");
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void roundOneWinSecond() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Ira", "Lena");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void roundTwoWinFirst() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Tanya", "Sasha");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void roundThreeDraw() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Vita", "Sasha");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayers() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Andrey", "Inna");

        });
    }

    @Test
    public void FirstPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Inna", "Anya");

        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Anya", "Inna");

        });
    }

}
