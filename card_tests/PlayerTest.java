import card_game.*;

import static org.junit.Assert.*;
import org.junit.*;

public class PlayerTest {

  Player player1;
  Player player2;
  Card card1;
  Card card2;

  @Before
  public void before(){
    player1 = new Player("Keith");
    player2 = new Player("Craig");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    player1.setHand(card1, card2);
  }

  @Test
  public void hasName(){
    assertEquals("Keith", player1.getName());
  }

  @Test
  public void handStartsEmpty(){
    assertNull(player2.getHand()[0]);
  }

  @Test 
  public void canSetHand(){
    assertEquals(card1, player1.getHand()[0]);
  }

  @Test 
  public void canGetHandValue(){
    assertEquals(5, player1.getHandValue());
  }


  @Test
  public void canPrintHand(){
    assertEquals("Two of Clubs, Three of Spades", player1.printHand());
  }

}