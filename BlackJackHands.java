import java.util.Random;
import java.util.Scanner;

public class BlackJackHands extends BlackjackCards{
    /**
     * This function creates the players first draw by picking
     * a random card and gets its value.
     */
    public static void playerFirstHand(){
        Random random = new Random();
        int firstCardIndex = random.nextInt(values.size());
        String firstCard = values.get(firstCardIndex);

        playerHand.add(deck.get(firstCardIndex));
        deck.remove(firstCardIndex);
        values.remove(firstCardIndex);

        if (firstCard.equals("Ace") || firstCard.equals("King")|| firstCard.equals("Queen")||firstCard.equals("Jack")){
            if (firstCard.equals("Ace")){
                points += 11;
                System.out.println("Points " + points);
                System.out.println(playerHand);
            } else if (firstCard.equals("King") || firstCard.equals("Queen") || firstCard.equals("Jack") ) {
                points += 10;
                System.out.println("Points " + points);
                System.out.println(playerHand);
            }
        }else{
            int point = Integer.parseInt(firstCard);
            points += point;
            System.out.println("Points " + points);
            System.out.println(playerHand);
        }
    }
    /**
     * This function creates the computers first draw by picking
     * a random card and gets its value
     */
    public static void computerFirstHand(){
        Random random = new Random();
        int computerFirstIndex = random.nextInt(values.size());
        String computerFirstCard = values.get(computerFirstIndex);
        computerHand.add(deck.get(computerFirstIndex));
        deck.remove(computerFirstIndex);
        values.remove(computerFirstIndex);

        if (computerFirstCard.equals("Ace") || computerFirstCard.equals("King")|| computerFirstCard.equals("Queen")||computerFirstCard.equals("Jack")){
            if (computerFirstCard.equals("Ace")){
                computerPoints += 11;
            } else if (computerFirstCard.equals("King") || computerFirstCard.equals("Queen") || computerFirstCard.equals("Jack") ) {
                computerPoints += 10;

            }
        }else{
            int comPoint = Integer.parseInt(computerFirstCard);
            computerPoints += comPoint;
        }
    }
    /**
     * This function creates the computers AI by giving it a choice to "HIT" or "Stand" if the
     * computer chooses "Hit" the computer is giving another random card which is then added to its hand.
     * Every new card increases the computers hands value.  If the computer chooses "stand" it doesn't draw
     * another card.
     */
    public static void computerTurn(){

        Random random = new Random();
        if (computerPoints < 10){
            computerChoice = computerChoices.get(0);
        }
        else if (computerPoints > 10){
            int choiceIndex = random.nextInt(computerChoices.size());
            computerChoice = computerChoices.get(choiceIndex);
        } else if (computerPoints > 19){
            computerChoice = computerChoices.get(1);
        }
        if (computerChoice.equalsIgnoreCase("stand")){
            System.out.println("Computer Standing.........");
            ComStandCount +=1;
        }  else {
            System.out.println("Computer Hits...........");

                int computerNextIndex = random.nextInt(values.size());
                String computerNext = values.get(computerNextIndex);

                computerHand.add(deck.get(computerNextIndex));
                values.remove(computerNextIndex);
                deck.remove(computerNextIndex);


                if (computerNext.equals("Ace") || computerNext.equals("King") || computerNext.equals("Queen") || computerNext.equals("Jack")) {
                    if (computerNext.equals("Ace")) {
                        if (computerPoints > 10) {
                            computerPoints += 1;
                        } else {
                            computerPoints += 11;
                        }
                    } else if (computerNext.equals("King") || computerNext.equals("Queen") || computerNext.equals("Jack")) {
                        computerPoints += 10;

                    }
                } else {
                    int comPoint = Integer.parseInt(computerNext);
                    computerPoints += comPoint;
                }
        }
    }
    /**
     * This function gives the player the choice to "HIT" or "Stand" if the
     * Player chooses "Hit" the player is giving another random card which is then added to its hand.
     * Every new card increases the players hands value. If the player chooses "Stand" they don't draw another
     * card
     */
    public static void playerTurn() {
            Random random = new Random();
            //playerStart
            Scanner input = new Scanner(System.in);
            System.out.print("Hit or stand? ");
            choice = input.nextLine();

            if (choice.equalsIgnoreCase("Hit")) {
                int nextCardIndex = random.nextInt(values.size());

                String nextCard = values.get(nextCardIndex);

                playerHand.add(deck.get(nextCardIndex));
                deck.remove(nextCardIndex);
                values.remove(nextCardIndex);
                System.out.println(playerHand.get(playerHand.size() - 1));

                if (nextCard.equals("Ace") || nextCard.equals("King") || nextCard.equals("Queen") || nextCard.equals("Jack")) {
                    if (nextCard.equals("Ace")) {
                        if (points > 10) {
                            points += 1;
                            System.out.println("Points " + points);
                        } else {
                            points += 11;
                        }
                    } else if (nextCard.equals("King") || nextCard.equals("Queen") || nextCard.equals("Jack")) {
                        points += 10;
                        System.out.println("Points " + points);
                    }
                } else {
                    int point = Integer.parseInt(nextCard);
                    points += point;
                    System.out.println("Points " + points);
                }

            } else {
                System.out.println("Player Standing.....");
                playerStandCount +=1;
                System.out.println("Points " + points);
            }
    }
}
