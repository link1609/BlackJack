import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BlackjackCards {
    static int points = 0;
    static int computerPoints = 0;


    static List<String> values= new ArrayList<>();
    static List<String> deck = new ArrayList<>();


    static List<String> playerHand = new ArrayList<>();
    static List<String> computerHand = new ArrayList<>();

    static int ComStandCount = 0;
    static int playerStandCount = 0;

    static String choice = "";
    static String computerChoice = "";
    static List <String> computerChoices = new ArrayList<>();

    static List <String> suits = new ArrayList<>();

    /**
     * Creating the values
     */

    public static void createValues(){
        Collections.addAll(values, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace",
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" );
    }
    /**
     * Creating the suits
     */
    public static void createSuits(){
        Collections.addAll(suits, " of Hearts", " of Diamonds", " of Spades", " of Clubs");
    }

    /**
     * Creating the deck by concatenating the values to the suits.
     */
    public static void createDeck() {
        Random random = new Random();
       for (int i = 0; i < values.size(); i ++) {
           int RandomSuit = random.nextInt(suits.size());

           deck.add(i, values.get(i) + suits.get(RandomSuit));

       }
    }

    /**
     * Builds the list of choices for the computer
     */
    public static void buildComputerChoices(){
        Collections.addAll(computerChoices, "Hit", "Stand");
    }

    /**
     * Calculates the points to find the winner
     */
    public static void calcPoints(){
        if (points > 21 && computerPoints > 21){
            System.out.println("Both lose");
            System.out.println();
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Player Hand: " + playerHand + "\nComputer Hand: " + computerHand);
        } else if (points == computerPoints) {
            System.out.println("Draw");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Player Hand: " + playerHand + "\nComputer Hand: " + computerHand);
        } else if (points == 21){
            System.out.println("Player has Blackjack, player wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Player Hand: " + playerHand);
        } else if (computerPoints == 21) {
            System.out.println("Computer has Blackjack, Computer wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Computer Hand: " + computerHand);
        } else if (points > 21) {
            System.out.println("Computer wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Computer Hand: " + computerHand);
        } else if (computerPoints > 21){
            System.out.println("Player wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Player Hand: " + playerHand);
        } else if (points > computerPoints) {
            System.out.println("Player wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Player Hand: " + playerHand);
        } else {
            System.out.println("Computer wins");
            System.out.printf("Player Points: %d  Computer points %d\n", points, computerPoints);
            System.out.println("Computer Hand: " + computerHand);
        }
    }

    /**
     * Cleans up for the next game.
     */
    public static void cleanUp(){
        points = 0;
        computerPoints = 0;
        playerHand.clear();
        computerHand.clear();
        ComStandCount = 0;
        playerStandCount = 0;
    }

}
