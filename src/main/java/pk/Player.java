package pk;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
    public int turn( String strategy, Card drawnCard){
        int score = 0;
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("TRACE"));
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
            return score;
        }

        Random r = new Random();
        int cardIndex = r.nextInt(35);
        if (drawnCard.type.equals("SeaBattle")){
            System.out.println("SEA BATTLE");
            score = seaBattleStrategy(occurrences,rolls,results, drawnCard.numRolls, drawnCard.bonus);

        }


        else if (strategy.equals("random")){
            score = randomStrategy(occurrences,rolls, rollable, results);

        }
        else if (strategy.equals("combo")){
            score = comboStrategy(occurrences, rolls, results);
        }
        return score;
    }

    public int seaBattleStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Faces> results, int saberRolls, int bonus){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("TRACE"));
        Dice dice = new Dice();
        ArrayList<Integer> rollable = new ArrayList<Integer>();
        int saberOccurrences = 0;
        logger.trace("Num of needed sabers is: " + saberRolls);
        for (int i = 1; i<9; i++) {
            logger.trace(rolls.get(i));
            if (rolls.get(i) ==Faces.SABER){
                saberOccurrences++;
            }

            if(!((rolls.get(i)== Faces.SABER) || (rolls.get(i)== Faces.SKULL))){
                rollable.add(i);
            }
        }
        while ((rollable.size()>1) &&(occurrences<3) && (saberOccurrences < saberRolls)){
            for(int i = 0; i < rollable.size(); i++){
                int diceNum = rollable.get(i);
                logger.trace("Dice " + diceNum + " " + rolls.get(diceNum));
                rolls.put(diceNum, dice.roll());
                logger.trace(rolls.get(diceNum));
                System.out.println("Next dice!");
            }
            for(int i = rollable.size()-1; i >=0; i--){
                int diceNum = rollable.get(i);
                if (rolls.get(diceNum) == Faces.SKULL){
                    occurrences++;
                    rollable.remove(i);
                }
                else if (rolls.get(diceNum) == Faces.SABER){
                    saberOccurrences++;
                    rollable.remove(i);
                }
            }
            logger.trace("reroll");

        }
        logger.trace("Num skulls " + occurrences);

        int turnScore;
        if (occurrences<3){
            for (int i = 1; i<9; i++) {
                logger.trace( "dice" + i + " " + rolls.get(i));
                results.add(rolls.get(i));
            }
            turnScore = score(results, bonus);
        }

        else{
            turnScore = score(results, -1*bonus);
        }

        return turnScore;



    }

    public int comboStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Faces> results){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("TRACE"));
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
            for(int i = rollable.size()-1; i >=0; i--){
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
        int score = score(results, 0);
        return score;

    }

    public int randomStrategy(int occurrences, HashMap<Integer, Faces> rolls, ArrayList<Integer> rollable, ArrayList<Faces> results){
        Logger loggerConfig = LogManager.getRootLogger();
        Configurator.setAllLevels(loggerConfig.getName(), Level.getLevel("TRACE"));
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
                return score(results, 0);
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
        return score(results, 0);

    }

    public int score(ArrayList<Faces> results, int bonus){
        HashMap<Integer, Integer> combos = new HashMap<Integer, Integer>();
        combos.put(0,0);
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


        for(Faces face: Faces.values()){
            logger.trace(face);
            logger.trace(Collections.frequency(results,face));
            score += combos.get(Collections.frequency(results,face));
            logger.trace(score);
        }
        score += bonus;

        return score;
    }

}
