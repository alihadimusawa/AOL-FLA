package facade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.TransactionManager;
import model.Transaction;

public class ViewTransactionWithinRange implements FacadeInterface {

    TransactionManager transactionManager;

    public ViewTransactionWithinRange(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
        main();
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is view transaction within range");
    }

    @Override
    public void main() {
        new ViewAllTransaction(transactionManager, "transaction");
        Scanner scanner = new Scanner(System.in);
        System.out.println("View Transactions within Date Range");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String tempDate = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(tempDate, formatter);
        
        System.out.print("Enter end date (YYYY-MM-DD): ");
        tempDate = scanner.nextLine(); // Read the correct end date
        LocalDate endDate = LocalDate.parse(tempDate, formatter);
        

        boolean found = transactionManager.getTransactionsWithinDateRange(startDate, endDate);
        if (!found) {
            System.out.println("No transactions found within the specified date range.");
        } else {
            new ViewAllTransaction(transactionManager, "filtered");
        }
    }

}
