import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nHello. Welcome to our ATM system.\n" +
                "If you want to create a new account - select [ 1 ].\n" +
                "If you already have an account and want to log in - select [ 2 ].\n" +
                "To exit - select [ 3 ]. \n");
        MenuATM menuATM = new MenuATM(new Scanner(System.in));
        menuATM.mainMenu();
    }       
}