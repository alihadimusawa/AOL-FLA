package facade;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TransactionManager;
import model.Transaction;

public class RemoveTransaction implements FacadeInterface {

    private ArrayList<Transaction> transactions;
    private TransactionManager transactionManager;
    private Scanner scanner;

    public RemoveTransaction(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.transactions = transactionManager.getAllTransactions();
        this.scanner = new Scanner(System.in);
        main();
    }

    public void main() {
        String transactionId;
        System.out.println("");
        while (true) {
            System.out.print("Enter the transaction ID to remove: ");
            transactionId = scanner.nextLine();
            if(!transactionId.isEmpty()) break;
        }

        transactionManager.removeTransaction(transactionId);
    }

    @Override
    public void check() {
        System.out.println("This is remove transactions facade");
    }
}
