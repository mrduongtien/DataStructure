package linked_list.doubly_linked_list.update;

import linked_list.doubly_linked_list.update.model.BankAccount;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        DoublyLinkedList<BankAccount> listBankAccounts = new DoublyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("======================= MENU =======================");
            System.out.println("1. Add new account");
            System.out.println("2. Update balance");
            System.out.println("3. Display list");
            System.out.println("0. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BankAccount account = createBankAcc(scanner);
                    listBankAccounts.addAccount(account);
                    break;
                case 2:
                    System.out.print("Input account number: ");
                    String accNumber = scanner.nextLine();
                    var foundNoe = listBankAccounts.getNode(new BankAccount(accNumber));
                    if (foundNoe != null) {
                        System.out.print("Input new balance: ");
                        BankAccount bankAccount = foundNoe.getData();
                        long balance = Long.parseLong(scanner.nextLine());
                        bankAccount.setBalance(balance);
                        listBankAccounts.updateBalanceOfAccount(foundNoe, bankAccount);
                        System.out.println("Success.");
                    } else {
                        System.out.println("This account does not exist. Balance update failed.");
                    }
                    break;
                case 3:
                    System.out.println("Account List: ");
                    listBankAccounts.displayList();
                    break;
                case 0:
                    System.out.println("======================= Thank you =======================");
                    break;

            }
        } while (choice != 0);

    }

    private static BankAccount createBankAcc(Scanner input) {
        BankAccount account = new BankAccount();
        System.out.println("Number card: ");
        String numberCard = input.nextLine();
        System.out.println("Account number: ");
        String accNumber = input.nextLine();
        System.out.println("Owner Name: ");
        String owner = input.nextLine();
        System.out.println("Bank name: ");
        String bankName = input.nextLine();
        System.out.println("Balance: ");
        long balance = Long.parseLong(input.nextLine());
        account.setNumberCard(numberCard);
        account.setAccountNumber(accNumber);
        account.setName(owner);
        account.setIssuingBank(bankName);
        account.setBalance(balance);
        return account;
    }

}
