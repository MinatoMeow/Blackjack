package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class ChaosDeck {
    
    private ArrayList<Cards> cards;
    
    public ChaosDeck() {
        this.cards = new ArrayList<>();
        
    }
    
    //Method to create a deck of cards
    public void createDeck() {
        
        for (int i = 0; i < 208; i++) {
            for(Suit cardSuit : Suit.values()) {

                for(Value cardValue : Value.values()) {

                    this.cards.add(new Cards(cardSuit, cardValue));

                }
            }
        }
    }
    
    //Choas Mode Shuffle
    public void chaoticShuffle() {
        ArrayList<Cards> temp = new ArrayList<>();
        Random ran = new Random();
        int randomCardIndex = 0;
        int orgSize = this.cards.size();
        for(int i = 0; i < orgSize; i++) {
            
            randomCardIndex = ran.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            temp.add(this.cards.get(randomCardIndex));
            
            this.cards.remove(randomCardIndex);
        }
        this.cards = temp;
    }
    
    @Override
    public String toString() {
        String cardList = "";
        
        for(Cards Card : this.cards) {
            cardList += "\n" +Card.toString();
        }
        return cardList;
    }
    
    public void removeCard(int i) {
        this.cards.remove(i);
    }
    
    public Cards getCard(int i) {
        return this.cards.get(i);
    }
    
    public void addCard(Cards addCard) {
        this.cards.add(addCard);
    }
    
    public void draw(ChaosDeck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
    
    public int deckSize() {
        return this.cards.size();
    }
    
    public void moveAllToDeck(ChaosDeck moveTo) {
        int thisDeckSize = this.cards.size();
        
        for(int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }
        
        for(int i = 0; i <thisDeckSize; i++) {
            this.removeCard(0);
        }
    }
    
    //Returns value of card
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;
        
        for(Cards aCard : this.cards) {
            switch(aCard.getValue()) {
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: aces += 1; break;
            }
        }
        
        //Determines if Ace should be 1 or 11
        for(int i = 0; i < aces; i++) {
            if(totalValue > 10) {
                totalValue +=1;
            } else {
                totalValue += 11;
            }
        }
        
        return totalValue;
    }
}
