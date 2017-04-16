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
  Card card3;
  Card card4;
  Card card5;
  Card card6;
  WinChecker winChecker;

  @Before
  public void before(){
    game = new Game();
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    card3 = new Card(8, Suit.Hearts);
    card4 = new Card(10, Suit.Diamonds);
    card5 = new Card(10, Suit.Clubs);
    card6 = new Card(11, Suit.Hearts);
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

  @Test
  public void closestToTwentyOneAndPlayerBurst(){
    player1.setHand(card1, card2);
    player2.setHand(card3, card4);
    player2.hitMe(card4);
    assertEquals("Player2 is burst! Player1 wins", winChecker.closestToTwentyOne());
  }

  @Test
  public void testBlackjack(){
    player1.setHand(card5, card6);
    player2.setHand(card1, card2);
    assertEquals("Player1 has blackjack! Player1 wins", winChecker.closestToTwentyOne());
  }

  @Test
  public void aceBecomesOne(){
    player1.setHand(card3, card6);
    player1.hitMe(card3);
    player2.setHand(card4, card3);
    assertEquals("Player2 wins", winChecker.closestToTwentyOne());
    assertEquals(17, player1.getHandValue());
    assertEquals(18, player2.getHandValue());
  }

}