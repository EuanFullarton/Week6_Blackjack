package card_game;
import card_game.*;

public class Player {

  private String name;
  private Card[] hand = new Card[4];

  public Player(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setHand(Card card1, Card card2){
    this.hand[0] = card1;
    this.hand[1] = card2;
  }

  public void hitMe(Card newCard){
    if (this.hand[2] != null) {
      this.hand[3] = newCard; 
    }
    else {
      this.hand[2] = newCard;
    }
  }

  public Card[] getHand(){
    return this.hand;
  }

  public int getHandValue(){
    if (this.hand[3] != null){
      return this.hand[0].getNumber() + this.hand[1].getNumber() + this.hand[2].getNumber() + this.hand[3].getNumber();
    }
    else if (this.hand[2] != null){
      return this.hand[0].getNumber() + this.hand[1].getNumber() + this.hand[2].getNumber();
    }     
    else {
      return this.hand[0].getNumber() + this.hand[1].getNumber();
    }
  }

  public String printHand(){
    return this.hand[0].toString() + ", " + this.hand[1].toString();
  }

}