package blackjack;

public class Cards {
    
    private Suit suit;
    private Value value;
    
    //Gets suit and value for each individual card
    public Cards(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }
    
    //Converts enum to string
    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }
    
    //Returns card value
    public Value getValue() {
        return this.value;
    }
}
