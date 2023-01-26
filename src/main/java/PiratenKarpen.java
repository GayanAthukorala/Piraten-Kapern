import pk.Dice;
import pk.Faces;
import pk.Player;

import javax.swing.plaf.basic.BasicListUI;
import java.util.*;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println("Player 1----------------");
        ArrayList p1Rolls = player1.turn();
        System.out.println("Player 2----------------");
        ArrayList p2Rolls = player2.turn();
        System.out.println("Player 1 Score: " +player1.score(p1Rolls) );
        System.out.println("Player 2 Score: " +player2.score(p2Rolls) );
        System.out.println("That's all folks!");
    }
    
}
