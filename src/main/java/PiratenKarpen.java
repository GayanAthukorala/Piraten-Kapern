import pk.Dice;
import pk.Faces;

import javax.swing.plaf.basic.BasicListUI;
import java.util.*;

public class PiratenKarpen {

    public static void turn(){
//        ArrayList<Faces> rolls = new ArrayList<Faces>();
        Dice dice1 = new Dice();
//        rolls.add(dice1.roll());
        Dice dice2 = new Dice();
//        rolls.add(dice2.roll());
        Dice dice3 = new Dice();
//        rolls.add(dice3.roll());
        Dice dice4 = new Dice();
//        rolls.add(dice4.roll());
        Dice dice5 = new Dice();
//        rolls.add(dice5.roll());
        Dice dice6 = new Dice();
//        rolls.add(dice6.roll());
        Dice dice7 = new Dice();
//        rolls.add(dice7.roll());
        Dice dice8 = new Dice();
//        rolls.add(dice8.roll());
//        System.out.println(rolls);
        HashMap<Dice, Faces> rolls = new HashMap<Dice, Faces>();
        rolls.put(dice1, dice1.roll());
        rolls.put(dice2, dice2.roll());
        rolls.put(dice3, dice3.roll());
        rolls.put(dice4, dice4.roll());
        rolls.put(dice5, dice5.roll());
        rolls.put(dice6, dice6.roll());
        rolls.put(dice7, dice7.roll());
        rolls.put(dice8, dice8.roll());

        int occurrences = Collections.frequency(rolls.values(), Faces.SKULL);
        if(occurrences >= 3){
            System.out.println("Game Over");
        }
        ArrayList<Integer> rollable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
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
        for (int i = 1; i<8;i++){
            if(rolls.get(dice.get(i))== Faces.SKULL){
                rollable.remove(i);
            }
        }
        int low = 1;
        int high = rollable.size();
        while (occurrences<3){
            int diceNum = r.nextInt(high-low) + low;
            while (!rollable.contains(diceNum)){
                diceNum = r.nextInt(high-low) + low;
            }
            rolls.put(dice.get(diceNum),(dice.get(diceNum)).roll());
            occurrences = Collections.frequency(rolls.values(), Faces.SKULL);
            System.out.println(occurrences);
        }
        for (int i = 1; i<8; i++) {

            System.out.println((dice.get(i) + " " + rolls.get(dice.get(i))));
        }



    }

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        turn();
        System.out.println("That's all folks!");
    }
    
}
