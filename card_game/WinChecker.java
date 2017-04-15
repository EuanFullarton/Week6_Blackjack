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


}