package main;

import controller.*;
import facade.AddTransaction;
import facade.ViewAllTransaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import model.Transaction;
import observer.LoggerTransactionObserver;

public class FinanceUI {
    private ViewAllTransaction viewAll;
    private TransactionManager transactionManager;
    private Scanner scanner;
    // ViewAllTransaction viewAll = new ViewAllTransaction(transactionManager);

    public FinanceUI() {
        transactionManager = new TransactionManager();
        scanner = new Scanner(System.in);
        viewAll = new ViewAllTransaction(transactionManager);

        transactionManager.addObserver(new LoggerTransactionObserver());
    }

    public void displayMenu() {
        System.out.println("Personal Finance Manager");
        System.out.println("1. Add a transaction");
        System.out.println("2. Remove a transaction");
        System.out.println("3. Calculate total income");
        System.out.println("4. Calculate total expense");
        System.out.println("5. View transactions within date range");
        System.out.println("6. View transactions by category");
        System.out.println("7. View all transactions");
        System.out.println("0. Exit");
    }

    public void handleUserInput() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                // add transaction
                case 1:
                    Transaction createdTransaction = new AddTransaction().main();
                    transactionManager.addTransaction(createdTransaction);
                    break;
                
                // remove transaction
                case 2:
                    removeTransaction();
                    break;

                // calculate total income
                case 3:
                    calculateTotalIncome();
                    break;

                // calculate total expense
                case 4:
                    calculateTotalExpense();
                    break;

                // view transaction within range
                case 5:
                    viewTransactionsWithinDateRange();
                    break;

                // view transaction within category
                case 6:
                    viewTransactionsByCategory();
                    break;
                
                // view all transactio
                case 7:
                    viewAll.main();
                    break;
                
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private void removeTransaction() {
        System.out.println("Remove a Transaction");

        System.out.print("Enter the transaction ID to remove: ");
        String transactionId = scanner.nextLine();

        boolean removed = transactionManager.removeTransaction(transactionId);
        if (removed) {
            System.out.println("Transaction removed successfully.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    private void calculateTotalIncome() {
        System.out.println("Calculate Total Income");

        double totalIncome = transactionManager.calculateTotalIncome();
        System.out.println("Total Income: " + totalIncome);
    }

    private void calculateTotalExpense() {
        System.out.println("Calculate Total Expense");

        double totalExpense = transactionManager.calculateTotalExpense();
        System.out.println("Total Expense: " + totalExpense);
    }

    private void viewTransactionsWithinDateRange() {
        System.out.println("View Transactions within Date Range");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String tempDate = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(tempDate, formatter);

        System.out.print("Enter end date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(tempDate, formatter);

        List<Transaction> transactions = transactionManager.getTransactionsWithinDateRange(startDate, endDate);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found within the specified date range.");
        } else {
            System.out.println("Transactions within the date range:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void viewTransactionsByCategory() {
        System.out.println("View Transactions by Category");

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        List<Transaction> transactions = transactionManager.getTransactionsByCategory(category);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for the specified category.");
        } else {
            System.out.println("Transactions for the category:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void viewAllTransactions() {
        System.out.println("View All Transactions");

        List<Transaction> transactions = transactionManager.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("All transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}
