import pk.Dice;
import pk.Faces;
import pk.Player;

import javax.swing.plaf.basic.BasicListUI;
import java.util.*;

public class PiratenKarpen {

    public static void main(String[] args) {
        int p1Wins = 0;
        int p2Wins = 0;
        Player player1 = new Player();
        Player player2 = new Player();
        for (int i = 0; i<42; i++) {
            System.out.println("Welcome to Piraten Karpen Simulator!");
            System.out.println("I'm rolling a dice");
            System.out.println("Player 1----------------");
            ArrayList p1Rolls = player1.turn();
            System.out.println("Player 2----------------");
            ArrayList p2Rolls = player2.turn();
            System.out.println("Player 1 Score: " + player1.score(p1Rolls));
            System.out.println("Player 2 Score: " + player2.score(p2Rolls));
            if (player1.score(p1Rolls) > player2.score(p2Rolls)) {
                p1Wins++;
            } else if (player2.score(p2Rolls) > player1.score(p1Rolls)) {
                p2Wins++;
            }
        }

        int p1WinPercent = (p1Wins/42)*100;
        int p2WinPercent = (p2Wins/42)*100;

        System.out.println("Player 1 Win Percentage: " + p1WinPercent +"%");
        System.out.println("Player 2 Win Percentage: " + p2WinPercent +"%");

    }

    
}
