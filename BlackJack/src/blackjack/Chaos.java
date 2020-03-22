package blackjack;

import static blackjack.Blackjack.playerChips;
import java.util.Scanner;

public class Chaos {

    public void Chaos() {
        
        //Creating deck and shuffling deck
        ChaosDeck playingDeck = new ChaosDeck();
        playingDeck.createDeck();
        playingDeck.chaoticShuffle();
        
        ChaosDeck playerDeck = new ChaosDeck();
        ChaosDeck dealerDeck = new ChaosDeck();
        
        Scanner userInput = new Scanner(System.in);
          
        //Game Loop
        while(Blackjack.playerChips > 0) {
            
            //Take bet
            System.out.println("Current Chips: " + Blackjack.playerChips);
            double playerBet = 0;

            if (userInput.hasNextDouble()) {
               playerBet = userInput.nextDouble(); 
            } else {
                break;
            }
            
            if (playerBet > playerChips) {
                break;
            }
            
            //Debugging card values
            //System.out.println(playingDeck);

            boolean endRound = false;

            //Player draws two cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //Dealer draws two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while(true) {
                System.out.println("***********************");
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("Deck Value: " + playerDeck.cardsValue());
                System.out.println("");
                
                //Dealer hand display
                System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
                System.out.println("***********************");

                //Start of game
                System.out.println("Hit:'1' or Stand:'2'?");
                int input = userInput.nextInt();

                //Hit
                if(input == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("***********************");
                    System.out.println("Card Drawn: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());

                    //Bust
                    if(playerDeck.cardsValue() > 21) {
                        System.out.println("You Bust!");
                        System.out.println("Total value: " + playerDeck.cardsValue());
                        Blackjack.playerChips -= (playerBet * 1.5);
                        endRound = true;
                        break;
                    }
                }

                //Stand
                if(input == 2) {
                    break;
                }
            }

            //Reveal Dealer's Hand
            System.out.println("Dealer's Hand: " + dealerDeck.toString());

            //Determine if dealer has larger value than player
            if((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound == false) {
                System.out.println("Dealer Wins!");
                Blackjack.playerChips -= (playerBet * 1.5);
                endRound = true;
            }
            
            //Determines if player has larger value than dealer
            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
                System.out.println("You Win!");
                Blackjack.playerChips += (playerBet * 1.5);
                endRound = true;
            } else if(endRound == false) {
                System.out.println("You Lose!");
                Blackjack.playerChips -= (playerBet * 1.5);
                endRound = true;
            }

            //Dealer hits at 16 and stands at 17
            while((dealerDeck.cardsValue() < 17) && endRound == false) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws" + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }
            
            //Display hand of the Dealer's value
            System.out.println("Hand of The Dealer's Value: " + dealerDeck.cardsValue());
            
            //Did Dealer bust
            if((dealerDeck.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer Busts! You Win!");
                Blackjack.playerChips += (playerBet * 1.5);
                endRound = true;
            }

            //Determine Push
            if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
                System.out.println("Push!");
                endRound = true;
            }

            //Moves cards back to the original deck
            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            
            System.out.println("***********************");
            System.out.println("");
            System.out.println("End of Hand.");

        }

        System.out.println("You have gone bankrupt!");
        
    }
    
}
