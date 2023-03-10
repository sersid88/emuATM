import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account extends Bank {
    private String pinCode;
    private String cardNumber;

    private List<Account> listAccounts = new ArrayList<>();

    private Bank bank = new Bank();

    public Account () {

    }

    public Account(String cardNumber, String pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;

    }

    //////////////////////////////////////ПОДУМАТЬ////////////////////////
    public Account(String cardNumber, String pinCode, Integer balance) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        super.setBalance(balance);
    }

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

    @Override
    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber  + '\'' +
                ", pinCode='" + pinCode  + '\'' +
                '}';
    }

    public  Account createNewAccount () {

        System.out.println("Please, enter your card's number in format: XXXX-XXXX-XXXX-XXXX");
        Scanner scanner = new Scanner(System.in);
        String cardNumberLine = scanner.nextLine();

        if (cardNumberLine.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
            System.out.println("Thank you");
        } else  {System.out.println("Wrong number, please enter correct number");
        return null;}

        System.out.println("Please, enter your card's PIN-code in format: XXXX");

        String cardPinCodeLine = scanner.nextLine();
        if (cardPinCodeLine.matches("\\d{4}")) {
            System.out.println("Thank you");;
        } else {System.out.println("Wrong code! Please enter correct pin-code");
        return null;}

        Account newCreatedAccount = new Account(cardNumberLine,cardPinCodeLine);
        listAccounts.add(newCreatedAccount);
        scanner.close();
        return newCreatedAccount;
    }



    public void  saveNewAccountToFile() {
        File listToFile = new File("C:\\Users\\sersid\\IdeaProjects\\training2\\src\\test.txt");

        try {
            PrintWriter pw = new PrintWriter(listToFile);
            pw.println(listAccounts.get(0).getCardNumber() + " " + getListAccounts().get(0).getPinCode() + " " + bank.getBalance());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public  void readFromFile() {
        File fileToList = new File("C:\\Users\\sersid\\IdeaProjects\\training2\\src\\test.txt");
        try {
            Scanner scanner = new Scanner(fileToList);
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                String[] lineFromFileArray = lineFromFile.split(" ");
                listAccounts.add(new Account(lineFromFileArray[0],lineFromFileArray[1],Integer.parseInt(lineFromFileArray[2])));

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void writeToFile() {
        File fromListToFile = new File("C:\\Users\\sersid\\IdeaProjects\\training2\\src\\test.txt");
        try {
            PrintWriter printWriter = new PrintWriter(fromListToFile);
            for (Account line: listAccounts) {
                printWriter.println(line.getCardNumber() + " " + line.getPinCode() + " " +line.getBalance());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public boolean accountLogin() {
        readFromFile();
        System.out.println("Please, enter your card's number");

        return true;
    }

}
