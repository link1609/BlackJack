

public class BlackJackPlay extends BlackJackHands {

    /**
     * This function checks if the points are below 21 and to see if there are enough cards in the deck to continue.
     * It also tacks the amount of times a player selects stand and if both player and computer stand twice the
     * game ends.  If both these conditions are met the games continues and calls the needed functions.
     */
    public static void play(){

        buildComputerChoices();
        playerFirstHand();
        computerFirstHand();
        while (points < 21 && computerPoints < 21) {
            if (deck.size() < 6) {
                System.out.println("Not enough cards to continue");
                break;
            }else if  (playerStandCount == 2 && ComStandCount ==2) {
                break;
            } else if (ComStandCount > 2) {
                break;
            } else if (playerStandCount > 2){
                break;
            } else {
                computerTurn();
                playerTurn();
            }

        }
        calcPoints();
        System.out.println(deck.size());


    }
}
