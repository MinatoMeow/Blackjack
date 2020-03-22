package blackjack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("***********************");
        System.out.println("Blackjack V0.0.1");
        System.out.println("Version done by Blake");
        System.out.println("***********************");
        System.out.println("");
        
        System.out.println("***********************");
        System.out.println("Type 'r' for rules");
        System.out.println("***********************");
        System.out.println("");
                
        System.out.println("***********************");
        System.out.println("Please select a gamemode:");
        System.out.println("Easy:'y' Medium:'u'");
        System.out.println("Hard:'i' Chaos:'o'");
        System.out.println("***********************");

        boolean modeDecided = false;
        //Scanner
        Scanner userInput = new Scanner(System.in);

        //Choose gamemode
        while(modeDecided == false) {
            char modeInput = userInput.next(".").charAt(0);

            Blackjack startGame = new Blackjack();
            Chaos startChaos = new Chaos();

            //Get Rules
            if(modeInput == 'r') {
                Rules r = new Rules();
                r.getRules();
                modeDecided = false;
            }
            //Easy
            if(modeInput == 'y') {
                Blackjack.playerChips = 300;
                modeDecided = true;
                System.out.println("You start with $300");
                startGame.Blackjack();
            }

            //Medium
            if(modeInput == 'u') {
                Blackjack.playerChips = 200;
                modeDecided = true;
                System.out.println("You start with $200");
                startGame.Blackjack();
            }

            //Hard
            if(modeInput == 'i') {
                Blackjack.playerChips = 100;
                modeDecided = true;
                System.out.println("You start with $100");
                startGame.Blackjack();
            }

            //Chaos
            if(modeInput == 'o') {
                Blackjack.playerChips = 200;
                modeDecided = true;
                System.out.println("You start with $200");
                System.out.println("Goodluck >:)");
                startChaos.Chaos();
            }

            //When unrecognized character is input
            if (modeInput != 'r' && modeInput != 'y' && modeInput != 'u' && modeInput != 'i' && modeInput != 'o') {
                System.out.println("Enter a valid character");
                modeDecided = false;
            }
        
        }
    }
    
}
