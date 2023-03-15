import java.util.Scanner;

public class Bank {
    private static int balance;
    private int operationValue;
    public Bank() {
    }
    public int getBalance() {
        return balance;
    }
    public int getOperationValue() {
        return operationValue;
    }
    public void setOperationValue(int operationValue) {
        this.operationValue = operationValue;
    }
    public void setBalance(int balance) {
        Bank.balance = balance;
    }
    public void showBalance() {
        System.out.printf("Your account balance is %d \n", getBalance());
    }
    public void upBalance() {
        System.out.println("Enter the replenishment amount: ");
        Scanner scanner = new Scanner(System.in);
        String amountOfOperation = scanner.nextLine();
        int intAmountOfOperation = Integer.parseInt(amountOfOperation);
        if (intAmountOfOperation <= 1_000_000) {
            setBalance(getBalance() + intAmountOfOperation);
            showBalance();
        } else System.out.println("The value of the operation must not exceed 1_000_000");
    }
    public void decreaseBalance() {
        System.out.println("How much do you want to withdraw? ");
        Scanner scanner = new Scanner(System.in);
        String amountDecreaseBalance = scanner.nextLine();
        int intAmountDecreaseBalance = Integer.parseInt(amountDecreaseBalance);
        if (intAmountDecreaseBalance <= getBalance()) {
            setBalance(getBalance() - intAmountDecreaseBalance);
            System.out.println("Ready!");
            showBalance();
        } else System.out.printf("The value of the operation must not exceed your balance: %d \n", getBalance());
    }
}
