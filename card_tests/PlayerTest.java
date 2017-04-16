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
  Card card4;
  Card card5;
  Card card6;
  WinChecker winChecker;

  @Before
  public void before(){
    player1 = new Player("Player1");
    player2 = new Player("Player2");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    card3 = new Card(5, Suit.Hearts);
    card4 = new Card(6, Suit.Diamonds);
    card5 = new Card(10, Suit.Clubs);
    card6 = new Card(11, Suit.Hearts);
    player1.setHand(card1, card2);
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    winChecker = new WinChecker(players);
  }

  @Test
  public void hasName(){
    assertEquals("Player1", player1.getName());
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
  public void canBeDealtThirdCard(){
    player1.setHand(card1, card2);
    player1.hitMe(card3);
    assertEquals(10, player1.getHandValue());
  }

  @Test
  public void canBeDealtFourthCard(){
    player1.setHand(card1, card1);
    player1.hitMe(card3);
    player1.hitMe(card4);
    assertEquals(15, player1.getHandValue());
  }

}