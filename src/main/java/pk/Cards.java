package pk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Cards {

    public ArrayList<Card> deck(){
        Card seaBattle1 = new Card();
        seaBattle1.numRolls=2;
        seaBattle1.bonus=300;
        seaBattle1.type = "SeaBattle";
        Card seaBattle2 = new Card();
        seaBattle2.numRolls=3;
        seaBattle2.bonus=500;
        seaBattle2.type = "SeaBattle";
        Card seaBattle3 = new Card();
        seaBattle3.numRolls=4;
        seaBattle3.bonus=1000;
        seaBattle3.type = "SeaBattle";

        Card nop = new Card();
        Card monkeyBusiness = new Card();
        monkeyBusiness.type = "MonkeyBusiness";

        ArrayList<Card> deck = new ArrayList<Card>();

        for (int i =0; i <2;i++){
            deck.add(seaBattle1);
            deck.add(seaBattle2);
            deck.add(seaBattle3);
        }
        for (int i = 0; i<4;i++){
            deck.add(monkeyBusiness);
        }
        for (int i=0; i<25;i++){
            deck.add(nop);
        }

        return deck;
    }

    public Card draw(ArrayList<Card> deck){
        Random r = new Random();
        int cardIndex = r.nextInt(deck.size());
        Card drawnCard = deck.get(cardIndex);
        return drawnCard;

    }
}
