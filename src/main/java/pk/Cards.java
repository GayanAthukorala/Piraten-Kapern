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
        seaBattle2.numRolls=2;
        seaBattle2.bonus=300;
        seaBattle2.type = "SeaBattle";
        Card seaBattle3 = new Card();
        seaBattle3.numRolls=3;
        seaBattle3.bonus=500;
        seaBattle3.type = "SeaBattle";
        Card seaBattle4 = new Card();
        seaBattle4.numRolls=3;
        seaBattle4.bonus=500;
        seaBattle4.type = "SeaBattle";
        Card seaBattle5 = new Card();
        seaBattle5.numRolls=4;
        seaBattle5.bonus=1000;
        seaBattle5.type = "SeaBattle";
        Card seaBattle6 = new Card();
        seaBattle6.numRolls=4;
        seaBattle6.bonus=1000;
        seaBattle6.type = "SeaBattle";
        Card nop1 = new Card();
        Card nop2 = new Card();
        Card nop3 = new Card();
        Card nop4 = new Card();
        Card nop5 = new Card();
        Card nop6 = new Card();
        Card nop7 = new Card();
        Card nop8 = new Card();
        Card nop9 = new Card();
        Card nop10 = new Card();
        Card nop11 = new Card();
        Card nop12 = new Card();
        Card nop13 = new Card();
        Card nop14 = new Card();
        Card nop15 = new Card();
        Card nop16 = new Card();
        Card nop17 = new Card();
        Card nop18 = new Card();
        Card nop19 = new Card();
        Card nop20 = new Card();
        Card nop21 = new Card();
        Card nop22 = new Card();
        Card nop23 = new Card();
        Card nop24 = new Card();
        Card nop25 = new Card();
        Card nop26 = new Card();
        Card nop27 = new Card();
        Card nop28 = new Card();
        Card nop29 = new Card();

        ArrayList<Card> deck = new ArrayList<Card>(Arrays.asList(seaBattle1,seaBattle2, seaBattle3, seaBattle4, seaBattle5, seaBattle6, nop1, nop2, nop3, nop4, nop5, nop6, nop7, nop8, nop9, nop10, nop11, nop12, nop13, nop14, nop15, nop16, nop17, nop18, nop19, nop20, nop21, nop22, nop23, nop24, nop25, nop26, nop27, nop28, nop29));

        return deck;
    }

    public Card draw(ArrayList<Card> deck){
        Random r = new Random();
        int cardIndex = r.nextInt(deck.size());
        Card drawnCard = deck.get(cardIndex);
        return drawnCard;

    }
}
