package card_game;

import card_game.*;
import java.util.*;

public class WinChecker {

  private ArrayList<Player> players;

  public WinChecker (ArrayList<Player> players) {
    this.players = players;
  } 

  public String highestHandTotal(){

    Player maxPlayer = players.get(0);

    for(Player p : players) {
      if(p.getHandValue() > maxPlayer.getHandValue()){
        maxPlayer = p;
      }
    }

    return maxPlayer.getName() + " wins";
  }

  public String closestToTwentyOne(){

    Player maxPlayer = players.get(0);
    Player burstPlayer = null;
    Player blackJack = null;
    int playerHasAce = 0;
    int playerHandTotal = 0;

    for(Player p : players) {

      playerHandTotal = p.getHandValue();
      
      if  (playerHandTotal == 21) {
        blackJack = p;
      }
      else if ((playerHandTotal > maxPlayer.getHandValue()) && (playerHandTotal <= 21)) {
        maxPlayer = p;
      }
      else if (((playerHandTotal > maxPlayer.getHandValue()) && (playerHandTotal > 21) && (p.printHand().contains("Ace")))) {
        playerHasAce = playerHandTotal - 10;

        if ((playerHasAce > maxPlayer.getHandValue()) && (playerHasAce <= 21)) {
          maxPlayer = p;
        }
        else if ((playerHasAce > 21)) {
          burstPlayer = p;
        }
      }

      else if ((playerHandTotal > maxPlayer.getHandValue()) && (playerHandTotal > 21)) {
        burstPlayer = p;
      }
      else if ((playerHandTotal > maxPlayer.getHandValue()) && (playerHandTotal > 21)) {
        burstPlayer = p;
      }


      if (blackJack != null) {
        return blackJack.getName() + " has blackjack!" + " " + blackJack.getName() + " wins";
      }
      else if(burstPlayer != null) {
        return burstPlayer.getName() + " is burst!" + " " + maxPlayer.getName() + " wins";
      }
    }
    return maxPlayer.getName() + " wins";

  }

}
