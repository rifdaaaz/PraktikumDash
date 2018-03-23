import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WorldBuilder world = new WorldBuilder();
        Scanner sc = new Scanner(System.in);


        System.out.println("Praktikan 1 di cell " + world.getPraktikan1().getPos());
        System.out.println("Praktikan 2 di cell " + world.getPraktikan2().getPos());

        

    }


}