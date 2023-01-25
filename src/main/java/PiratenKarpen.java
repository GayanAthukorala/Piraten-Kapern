import pk.Dice;
import pk.Faces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class PiratenKarpen {

    public static void turn(){
        ArrayList<Faces> rolls = new ArrayList<Faces>();
        Dice dice1 = new Dice();
        rolls.add(dice1.roll());
        Dice dice2 = new Dice();
        rolls.add(dice2.roll());
        Dice dice3 = new Dice();
        rolls.add(dice3.roll());
        Dice dice4 = new Dice();
        rolls.add(dice4.roll());
        Dice dice5 = new Dice();
        rolls.add(dice5.roll());
        Dice dice6 = new Dice();
        rolls.add(dice6.roll());
        Dice dice7 = new Dice();
        rolls.add(dice7.roll());
        Dice dice8 = new Dice();
        rolls.add(dice8.roll());
        System.out.println(rolls);
        int occurrences = Collections.frequency(rolls, Faces.SKULL);
        if(occurrences >= 3){
            System.out.println("Game Over");
        }
        HashMap<Integer, Dice> dice = new HashMap<Integer, Dice>();
        dice.put(1,dice1);
        dice.put(2,dice2);
        dice.put(4,dice4);
        dice.put(3,dice4);
        dice.put(5,dice5);
        dice.put(6,dice6);
        dice.put(7,dice7);
        dice.put(8,dice8);
        Random r = new Random();
        int low = 1;
        int high = 8;
        while (occurrences<3){
            int result = r.nextInt(high-low) + low;
            rolls.set(result,(dice.get(result)).roll());
            System.out.println(rolls);
            occurrences =  Collections.frequency(rolls, Faces.SKULL);
        }



    }

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        turn();
        System.out.println("That's all folks!");
    }
    
}
