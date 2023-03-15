import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuATM {

    private final Scanner scanner;

    public MenuATM(Scanner scanner) throws FileNotFoundException {
        this.scanner = scanner;
    }


    Account account = new Account();




    public void printMainMenu() {
        System.out.println("******************************************************************");
        System.out.println("[ 1 ] 'Create new account.' ");
        System.out.println("[ 2 ] 'I have an account. Sign in with my card number.' ");
        System.out.println("[ 3 ] 'Exit.'");
        System.out.println("******************************************************************  \n ");
    }

    public void printATMMenu() {
        System.out.println("******************************************************************");
        System.out.println("[ 1 ] 'Show balance' ");
        System.out.println("[ 2 ] 'Deposit the amount' ");
        System.out.println("[ 3 ] 'Withdraw the amount' ");
        System.out.println("[ 4 ] 'Return to main menu' ");
        System.out.println("[ 5 ] 'Exit' ");
        System.out.println("******************************************************************  \n ");
    }

    public void mainMenu() throws FileNotFoundException {

        if (this.scanner != null) {
            int key;
            do {
                printMainMenu();
                System.out.println("Please enter menu number: ");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        account.createNewAccount();
                        account.saveNewAccountToFile();
                        break;
                    case 2:
                        if (account.accountLogin()) {
                            bankMenu();
                        } else System.out.println("User data does not match. Try once more.");
                        break;
                    case 3:
                        System.out.println("Thank you for using our ATM. We will be glad to see you again.");
                        break;
                    default:
                        System.out.println("Wrong menu number. Try once more.");
                }

            } while (key != 3);
        } //scanner.close();
    }
    public void bankMenu() throws FileNotFoundException {
        if (this.scanner != null) {
            int key;
            do {
            printATMMenu();
            System.out.println("Please enter menu number: ");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    account.showBalance();
                    break;
                case 2:
                    account.upBalance();
                    account.writeToFile();
                    break;
                case 3:
                    account.decreaseBalance();
                    account.writeToFile();
                    break;
                case 4:
                    mainMenu();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. We will be glad to see you again.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong menu number");
                }
            } while (key !=4);
        } //scanner.close();
    }


}
