package facade;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TransactionManager;
import model.Transaction;

public class ViewTransacionFromCategory implements FacadeInterface{
    TransactionManager transactionManager;

    public ViewTransacionFromCategory(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        main();
    }

    public void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("View Transactions by Category");
        String category;
        while (true) {
            System.out.print("Enter category: ");
            category = scanner.nextLine();
            break;
        }

        boolean found = transactionManager.getTransactionsByCategory(category);
        if (!found) {
            System.out.println("No transactions found for the specified category.");
        } else {
            new ViewAllTransaction(transactionManager);
        }

    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is view transaction from category");
    }
}
