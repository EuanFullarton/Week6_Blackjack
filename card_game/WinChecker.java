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

    for(Player p : players) {
      if((p.getHandValue() > maxPlayer.getHandValue()) && p.getHandValue() <= 21) {
        maxPlayer = p;
      }
      else if ((p.getHandValue() > maxPlayer.getHandValue()) && p.getHandValue() > 21) {
        burstPlayer = p;
      }
    }
    if(burstPlayer != null) {
      return burstPlayer.getName() + " is burst!" + " " + maxPlayer.getName() + " wins";
    }
    return maxPlayer.getName() + " wins";
  }
}