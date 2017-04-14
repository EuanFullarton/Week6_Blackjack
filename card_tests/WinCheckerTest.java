import card_game.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class WinCheckerTest {
  
  Game game;
  Player player1;
  Player player2;
  Card card1;
  Card card2;
  WinChecker winChecker;

  @Before
  public void before(){
    game = new Game();
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    winChecker = new WinChecker(players);

  }

  @Test
  public void highestHandWins(){
    player1.setHand(card1, card2);
    player2.setHand(card1, card1);
    assertEquals("Player1 wins", winChecker.highestHandTotal());
  }


}