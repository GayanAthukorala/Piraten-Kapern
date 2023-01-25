import pk.Dice;

public class PiratenKarpen {

    public static void turn(){
        Dice dice1 = new Dice();
        System.out.println(dice1.roll());
        Dice dice2 = new Dice();
        System.out.println(dice2.roll());
        Dice dice3 = new Dice();
        System.out.println(dice3.roll());
        Dice dice4 = new Dice();
        System.out.println(dice4.roll());
        Dice dice5 = new Dice();
        System.out.println(dice5.roll());
        Dice dice6 = new Dice();
        System.out.println(dice6.roll());
        Dice dice7 = new Dice();
        System.out.println(dice7.roll());
        Dice dice8 = new Dice();
        System.out.println(dice8.roll());

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        turn();
        System.out.println("That's all folks!");
    }
    
}
