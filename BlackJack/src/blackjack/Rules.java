
package blackjack;

public class Rules {
    
    public void getRules() {
        System.out.println("The rules of Blackjack are very simple");
        System.out.println("The goal is to beat the dealer's hand without going over 21.");
        System.out.println("You will start with two random cards, one of the dealer's cards is hidden until the end.");
        System.out.println("To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.");
        System.out.println("");
        System.out.println("In easy you start with $300.");
        System.out.println("In medium you start with $200.");
        System.out.println("In hard you start with $100.");
        System.out.println("In chaos you start with $200, but the rules are a bit different.");
        System.out.println("In chaos you have four deck of cards put together.");
        System.out.println("Earnings and loses are multiplied by 1.5.");
        System.out.println("");
        System.out.println("A good way to start is by betting small.");
        System.out.println("Then keep betting larger and larger values.");
        System.out.println("To quit. Select any key that is not a numerical value");
    }   
}
