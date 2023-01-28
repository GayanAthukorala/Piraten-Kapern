import pk.Dice;
import pk.Faces;
import pk.Player;

import javax.swing.plaf.basic.BasicListUI;
import java.sql.SQLOutput;
import java.util.*;

public class PiratenKarpen {

    public static void runGame(Player player1, Player player2){
        float p1Wins = 0;
        float p2Wins = 0;
        for (int i = 0; i<42; i++) {
            int p1Score = 0;
            int p2Score = 0;
            System.out.println("Welcome to Piraten Karpen Simulator!");
            while ((p1Score <6000) && (p2Score <6000)){
                System.out.println("Player 1----------------");
                ArrayList p1Rolls = player1.turn();
                System.out.println("Player 2----------------");
                ArrayList p2Rolls = player2.turn();
                System.out.println("Player 1 Score: " + player1.score(p1Rolls));
                System.out.println("Player 2 Score: " + player2.score(p2Rolls));
                p1Score += player1.score(p1Rolls);
                p2Score += player2.score(p2Rolls);
                System.out.println("Player 1 TOTAL score: " + p1Score );
                System.out.println("Player 2 TOTAL score: " + p2Score);
            }

            if (p1Score >= 6000){
                System.out.println("P1 WIN");
                p1Wins++;
            }
            else if (p2Score >= 6000){
                System.out.println("P2 WIN");
                p2Wins++;
            }
        }
        winPercent(p1Wins,p2Wins);

    }

    public static void winPercent(float p1Wins, float p2Wins){
        float p1WinPercent = (p1Wins/42)*100;
        float p2WinPercent = (p2Wins/42)*100;

        System.out.printf("Player 1 Win Percentage: %.2f",  p1WinPercent);
        System.out.println("%\n");
        System.out.printf("Player 2 Win Percentage: %.2f", p2WinPercent);
        System.out.println("%\n");
    }

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        runGame(player1, player2);
    }

    
}
