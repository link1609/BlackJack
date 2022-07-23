
import java.util.Collections;
import java.util.Scanner;

public class Blackjack extends BlackJackPlay{
    public static void main(String[] args) {
        createValues();
        Collections.shuffle(values);
        createSuits();
        createDeck();
        System.out.println(deck);


        System.out.println(BlackjackArt.art);
        boolean playing = true;
        Scanner input = new Scanner(System.in);

            while (playing){

                System.out.print("Do you want to play BlackJack? ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Yes")){
                    playing = true;

                    if(deck.size() < 6){
                        System.out.println("Game over not enough cards");
                        playing = false;
                    } else {
                        play();
                       cleanUp();
                    }

                } else {
                    System.out.println("Goodbye\nQuiting......\n....");
                    System.out.println(BlackjackArt.bye);
                    playing = false;
                }
        }
            input.close();
    }
}
