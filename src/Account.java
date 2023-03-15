import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account extends Bank {
    private String pinCode;
    private String cardNumber;
    private static List<Account> listAccounts = new ArrayList<>();
    private Bank bank = new Bank();
    File listDataBase = new File("C:\\Users\\sersid\\IdeaProjects\\training2\\src\\test.txt");
    public Account() throws FileNotFoundException {

    }
    public Account(String cardNumber, String pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
    }
    public Account(String cardNumber, String pinCode, Integer balance) throws FileNotFoundException {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        super.setBalance(balance);

    }

    ////////////////////////////////////GET-теры и SET-теры/////////////////////////////////////////////////////////

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Account> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(List<Account> listAccounts) {
        this.listAccounts = listAccounts;
    }

    //////////////////////////////////////////////МЕТОДЫ/////////////////////////////////////////////////////////////

    public void printList() {
        System.out.println(listAccounts);
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                "balance='" + getBalance() + '}';
    }

    public Account createNewAccount() throws FileNotFoundException {
        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Please, enter your card's number in format: XXXX-XXXX-XXXX-XXXX");
        String cardNumberLine = scannerSystem.nextLine();

        if (cardNumberLine.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
            System.out.println("Thank you");
        } else {
            System.out.println("Wrong number, please enter correct number");
            return null;
        }

        System.out.println("Please, enter your card's PIN-code in format: XXXX");

        String cardPinCodeLine = scannerSystem.nextLine();
        if (cardPinCodeLine.matches("\\d{4}")) {
            System.out.println("Thank you for registration. What else do you want to do? \n");

        } else {
            System.out.println("Wrong code! Please enter correct pin-code");
            return null;
        }

        Account newCreatedAccount = new Account(cardNumberLine, cardPinCodeLine);
        listAccounts.add(newCreatedAccount);

        return newCreatedAccount;
    }

    public void saveNewAccountToFile() {
        try (PrintWriter printWriter = new PrintWriter(listDataBase)) {

            printWriter.println(getListAccounts().get(0).getCardNumber() + " " + getListAccounts().get(0).getPinCode() +
                    " " + getListAccounts().get(0).getBalance());
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void readFromFile() {
        //File fileToList = new File("C:\\Users\\sersid\\IdeaProjects\\training2\\src\\test.txt");
        try (Scanner scannerFile = new Scanner(listDataBase)) {

            while (scannerFile.hasNextLine()) {
                String lineFromFile = scannerFile.nextLine();
                String[] lineFromFileArray = lineFromFile.split(" ");
                listAccounts.add(new Account(lineFromFileArray[0], lineFromFileArray[1], Integer.parseInt(lineFromFileArray[2])));

            }
            //scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void writeToFile() {
        try (PrintWriter printWriter = new PrintWriter(listDataBase)) {
            printWriter.println(listAccounts.get(0).cardNumber + " " + listAccounts.get(0).pinCode + " " + listAccounts.get(0).getBalance());
            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public boolean accountLogin() {

        readFromFile();
        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Please, enter your card's number");
        String loginCardNumber = scannerSystem.nextLine();
        if (loginCardNumber.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
            System.out.println("Thank you");
        } else {
            System.out.println("Wrong number, please enter correct number");
            return false;
        }
        System.out.println("Please, enter your PIN-code");
        String loginPinCode = scannerSystem.nextLine();
        if (loginPinCode.matches("\\d{4}")) {
            System.out.println("Thank you");
        } else {
            System.out.println("Wrong code! Please enter correct pin-code");
            return false;
        }
        //todo пересмотреть этот метод. объект класса bank
        for (Account account : getListAccounts()) {
            if (account.getCardNumber().equals(loginCardNumber) && account.getPinCode().equals(loginPinCode)) {
                System.out.printf("Successfully! Balance: %d \n" , bank.getBalance() );
                return true;
            } else System.out.println("Card number and pin-code do not match!");
        }

        return false;
    }

}
