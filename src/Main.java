import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Account account = new Account();
        //account.createNewAccount();
        //account.saveNewAccountToFile();
        //account.upBalance(200);

        account.readFromFile();
        //account.upBalance();
        account.decreaseBalance();
        account.writeToFile();

        //System.out.println(account.accountLogin());
        account.printList();


    }       
}