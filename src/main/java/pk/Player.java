package pk;

import java.sql.SQLOutput;
import java.util.*;

public class Player {
    public ArrayList turn(){
        ArrayList<Faces> results = new ArrayList<Faces>();
        Dice dice = new Dice();
        int occurrences = 0;
        HashMap<Integer, Faces> rolls = new HashMap<Integer, Faces>();
        ArrayList<Integer> rollable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));

        for (int i = 1; i<9; i++){
            Faces diceVal = dice.roll();
            rolls.put(i, diceVal);
        }

        for (int i = 1; i<9;i++){
            System.out.println( "dice" + i + " " + rolls.get(i));
            if(rolls.get(i)== Faces.SKULL){
                rollable.remove(Integer.valueOf(i));
                occurrences ++;
            }
        }

        if(occurrences >= 3){
            System.out.println("Game Over");
            return results;
        }

        results = randomStrategy(occurrences,rolls, rollable, results);
        return results;
    }

    public ArrayList<Faces> randomStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Integer> rollable, ArrayList<Faces> results){
        Dice dice = new Dice();
        Random r = new Random();
        while (occurrences<3){
            int reRoll = r.nextInt(2);
            if (reRoll == 0){
                System.out.println("Results:");
                System.out.println("--------");
                for (int i = 1; i<9; i++) {
                    System.out.println( "dice" + i + " " + rolls.get(i));
                    results.add(rolls.get(i));
                }
                return results;
            }

            System.out.println("Re-rolling");
            ArrayList<Integer> turnRollable = (ArrayList)rollable.clone();

            int numRolls = r.nextInt(rollable.size()-2) + 2;
            for (int i = 0; i < numRolls; i++){
                int low = 1;
                int high = turnRollable.size();
                int diceNumIndex = r.nextInt(high-low) + low;
                int diceNum = turnRollable.get(diceNumIndex);

                rolls.put(diceNum, dice.roll());
                System.out.println( "dice" + diceNum + " " + rolls.get(diceNum));
                turnRollable.remove(Integer.valueOf(diceNum));
                if(rolls.get(diceNum)== Faces.SKULL){
                    rollable.remove(Integer.valueOf(diceNum));
                    occurrences++;
                }
            }

//            System.out.println("Num skulls: " + occurrences);
//            System.out.println(rollable);
        }
        System.out.println("Busted!");
        return results;

    }

    public int score(ArrayList results){
        int score = 0;
        for (int i = 0; i<results.size(); i++) {
            if((results.get(i)== Faces.GOLD) || (results.get(i)== Faces.DIAMOND)){
                score += 100;
            }
        }
        return score;
    }

}
