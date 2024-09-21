/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1.
 * @author srinivsi
 * @modifier Kamrul Hasan
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];  
        Random random = new Random();

        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[random.nextInt(4)]); 
            magicHand[i] = c;  
            System.out.println("Card " + (i + 1) + ": " + c.getValue() + " of " + c.getSuit());
        }

        
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card (enter value between 1 and 13): ");
        int userValue = input.nextInt();
        input.nextLine();  
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.nextLine();

        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        
        boolean foundLuckyCard = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                foundLuckyCard = true;
                break;
            }
        }

        if (foundLuckyCard) {
            System.out.println("The lucky card (2 of Clubs) is in the magic hand! You win!");
        } else {
            System.out.println("The lucky card (2 of Clubs) is not in the magic hand.");
        }

        input.close();
    }
}