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
        player1.turn();
        player2.turn();
        System.out.println("That's all folks!");
    }
    
}
