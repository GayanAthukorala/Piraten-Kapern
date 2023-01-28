package pk;

import java.sql.SQLOutput;
import java.util.*;

public class Player {
    public ArrayList turn(){
        ArrayList<Faces> results = new ArrayList<Faces>();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice dice6 = new Dice();
        Dice dice7 = new Dice();
        Dice dice8 = new Dice();
        HashMap<Dice, Faces> rolls = new HashMap<Dice, Faces>();
        rolls.put(dice1, dice1.roll());
        rolls.put(dice2, dice2.roll());
        rolls.put(dice3, dice3.roll());
        rolls.put(dice4, dice4.roll());
        rolls.put(dice5, dice5.roll());
        rolls.put(dice6, dice6.roll());
        rolls.put(dice7, dice7.roll());
        rolls.put(dice8, dice8.roll());

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
        int occurrences = 0;
        for (int i = 1; i<9; i++) {
//            System.out.println( "dice" + i + " " + rolls.get(dice.get(i)));
        }
        for (int i = 1; i<9;i++){
//            System.out.println(rolls.get(dice.get(i)));
            if(rolls.get(dice.get(i))== Faces.SKULL){
                rollable.remove(Integer.valueOf(i));
                occurrences ++;
            }
        }

        if(occurrences >= 3){
            System.out.println("Game Over");
            for (int i = 0; i<9; i++) {
//                System.out.println( "dice" + i + " " + rolls.get(dice.get(i)));
                results.add(rolls.get(dice.get(i)));
            }
            return results;
        }
//        System.out.println(rollable);
        Random r = new Random();
        while (occurrences<3){
//            System.out.println("Rollable Dice: " + rollable);
            ArrayList<Integer> turnRollable = (ArrayList)rollable.clone();
            int numRolls = r.nextInt(rollable.size()-2) + 2;

            for (int i = 1; i < numRolls; i++){
//                System.out.println("Rollable Dice this Turn: " + turnRollable);
                int low = 1;
                int high = turnRollable.size();
                int diceNumIndex = r.nextInt(high-low) + low;
                int diceNum = turnRollable.get(diceNumIndex);

//                System.out.println("Dice getting rerolled is: " + diceNum);
                rolls.put(dice.get(diceNum),(dice.get(diceNum)).roll());
//                System.out.println( "dice" + diceNum + " " + rolls.get(dice.get(diceNum)));
                turnRollable.remove(Integer.valueOf(diceNum));
                if(rolls.get(dice.get(diceNum))== Faces.SKULL){
                    rollable.remove(Integer.valueOf(diceNum));
                    occurrences++;
//                    System.out.println(rollable);
                }
            }

//            System.out.println("Num skulls: " + occurrences);
//            System.out.println(rollable);
        }
        for (int i = 1; i<9; i++) {
//            System.out.println( "dice" + i + " " + rolls.get(dice.get(i)));
            results.add(rolls.get(dice.get(i)));

        }
        return results;
    }

    public int score(ArrayList results){
        System.out.println(results);
        int score = 0;
        for (int i = 0; i<results.size(); i++) {
            if((results.get(i)== Faces.GOLD) || (results.get(i)== Faces.DIAMOND)){
                System.out.println(results.get(i));
                score += 100;
            }
        }
        return score;
    }

}
