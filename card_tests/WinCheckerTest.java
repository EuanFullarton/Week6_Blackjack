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

  @Before
  public void before(){
    game = new Game();
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);

  }

  // @Test
  // public void returnTotalHandValue(){
  //   player1.setHand(card1, card2);
  //   assertEquals(5, winChecker.totalHandValue());
  // }


  // @Test
  // public void doesHighestCardWin(){
  //   player1.setHand(card1, card2);
  //   player2.setHand(card1, card1);
  //   assertEquals("Player1 wins", winChecker.highestCardWins());
  // }


}