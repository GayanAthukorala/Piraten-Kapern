package pk;

import java.sql.SQLOutput;
import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
    public ArrayList turn( String strategy){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("ERROR"));
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
//            logger.trace( "dice" + i + " " + rolls.get(i));
            if(rolls.get(i)== Faces.SKULL){
                rollable.remove(Integer.valueOf(i));
                occurrences ++;
            }
        }

        if(occurrences >= 3){
            logger.trace("Game Over");
            return results;
        }

        if (strategy.equals("random")){
            results = randomStrategy(occurrences,rolls, rollable, results);

        }
        else if (strategy.equals("combo")){
            results = comboStrategy(occurrences, rolls, results);
        }
        return results;
    }

    public ArrayList<Faces> comboStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Faces> results){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("ERROR"));
        Dice dice = new Dice();
        ArrayList<Faces> comboRollable = new ArrayList<Faces>();
        ArrayList<Integer> rollable = new ArrayList<Integer>();

        for (int i = 1; i<9; i++) {
            if(!((rolls.get(i)== Faces.GOLD) || (rolls.get(i)== Faces.DIAMOND) || (rolls.get(i)== Faces.SKULL))){
                comboRollable.add(rolls.get(i));

            }
        }

        Faces comboFace = null;
        int mostOccurences = -1;
        for(Faces face: comboRollable){
            int faceFrequency = (Collections.frequency(comboRollable,face));
            if (faceFrequency>mostOccurences){
                mostOccurences = faceFrequency;
                comboFace = face;
            }
        }
        logger.trace(comboFace);

//        for (int i = 1; i<9; i++) {
//            if(((rolls.get(i)== comboFace))){
//                comboRollable.remove(rolls.get(i));
//            }
//        }

        for (int i = 1; i<9; i++) {
            if(!((rolls.get(i)== Faces.GOLD) || (rolls.get(i)== Faces.DIAMOND) || (rolls.get(i)== Faces.SKULL) || (rolls.get(i)== comboFace))){
                rollable.add(i);
            }
        }
        logger.trace(rollable);


        while ((rollable.size()>1) &&(occurrences<3) && (mostOccurences <3)){
            for(int i = 0; i < rollable.size(); i++){
                int diceNum = rollable.get(i);
                logger.trace("Dice is " + rolls.get(diceNum));
                rolls.put(diceNum, dice.roll());
                logger.trace(rolls.get(diceNum));
            }
            for(int i = 0; i < rollable.size(); i++){
                int diceNum = rollable.get(i);
                if (rolls.get(diceNum) == Faces.SKULL){
                    occurrences++;
                    rollable.remove(i);
                }
                else if (rolls.get(diceNum) == comboFace){
                    mostOccurences++;
                    rollable.remove(i);
                }
            }
        }

        if (occurrences<3){
            for (int i = 1; i<9; i++) {
                logger.trace( "dice" + i + " " + rolls.get(i));
                results.add(rolls.get(i));
            }

        }
        return results;

    }

    public ArrayList<Faces> randomStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Integer> rollable, ArrayList<Faces> results){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("ERROR"));
        Dice dice = new Dice();
        Random r = new Random();
        while (occurrences<3){
            int reRoll = r.nextInt(2);
            if (reRoll == 0){
                logger.trace("Results:");
                logger.trace("--------");
                for (int i = 1; i<9; i++) {
                    logger.trace( "dice" + i + " " + rolls.get(i));
                    results.add(rolls.get(i));
                }
                return results;
            }

            logger.trace("Re-rolling");
            ArrayList<Integer> turnRollable = (ArrayList)rollable.clone();

            int numRolls = r.nextInt(rollable.size()-2) + 2;
            for (int i = 0; i < numRolls; i++){
                int low = 1;
                int high = turnRollable.size();
                int diceNumIndex = r.nextInt(high-low) + low;
                int diceNum = turnRollable.get(diceNumIndex);

                rolls.put(diceNum, dice.roll());
                logger.trace( "dice" + diceNum + " " + rolls.get(diceNum));
                turnRollable.remove(Integer.valueOf(diceNum));
                if(rolls.get(diceNum)== Faces.SKULL){
                    rollable.remove(Integer.valueOf(diceNum));
                    occurrences++;
                }
            }

//            System.out.println("Num skulls: " + occurrences);
//            System.out.println(rollable);
        }
        logger.trace("Busted!");
        return results;

    }

    public int score(ArrayList<Faces> results){
        HashMap<Integer, Integer> combos = new HashMap<Integer, Integer>();
        combos.put(1,0);
        combos.put(2,0);
        combos.put(3,100);
        combos.put(4,200);
        combos.put(5,500);
        combos.put(6,1000);
        combos.put(7,2000);
        combos.put(8,4000);
        int score = 0;
        for (int i = 0; i<results.size(); i++) {
            if((results.get(i)== Faces.GOLD) || (results.get(i)== Faces.DIAMOND)){
                score += 100;
            }
        }

        for(Faces face: results){
            score += combos.get(Collections.frequency(results,face));
        }

        return score;
    }

}
