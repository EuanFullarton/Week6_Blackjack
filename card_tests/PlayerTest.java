import card_game.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class PlayerTest {

  Player player1;
  Player player2;
  Card card1;
  Card card2;
  Card card3;
  WinChecker winChecker;

  @Before
  public void before(){
    player1 = new Player("Keith");
    player2 = new Player("Craig");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    card3 = new Card(5, Suit.Hearts);
    player1.setHand(card1, card2);
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    winChecker = new WinChecker(players);
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

  @Test
  public void canBeDealtAnotherCard(){
    player1.setHand(card1, card2);
    player2.setHand(card1, card1);
    player2.hitMe(card3);
    assertEquals("Player2 wins", winChecker.highestHandTotal());
  }

}