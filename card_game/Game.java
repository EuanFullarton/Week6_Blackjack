package card_game;
import card_game.*;

import java.util.*;

public class Game {

  private ArrayList<Player> players = new ArrayList<Player>();
  private static ArrayList<Card> deck = new ArrayList<Card>();

  public void buildDeck(){
    for (int i=1; i<14; i++) {
      for(Suit suit : Suit.values()){
        deck.add(new Card(i, suit));
      }
    }
    shuffleDeck();
  }

  public Game(){
    buildDeck();
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public ArrayList<Card> getDeck(){
    return this.deck;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public int playerCount(){
    return players.size();
  }

  public void deal(){
    for (Player player : this.players){
      player.setHand(deck.get(0), deck.get(1));
      deck.remove(0);
      deck.remove(0);
    } 
  }




}