package main;

import controller.*;
import facade.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import model.Transaction;

public class FinanceUI {

    private TransactionManager transactionManager;
    private Scanner scanner;

    // Initializing Facades
    FacadeInterface facade;

    public FinanceUI() {
        transactionManager = new TransactionManager();
        scanner = new Scanner(System.in);
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
        System.out.print(">> ");
    }

    public void handleUserInput() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1)
                facade = new AddTransaction(transactionManager);
            else if (choice == 2) {
                facade = new ViewAllTransaction(transactionManager);
                facade = new RemoveTransaction(transactionManager);
            } else if (choice == 3)
                facade = new CalculateTotalIncome(transactionManager);
            else if (choice == 4)
                facade = new CalculateTotalExpense(transactionManager);
            else if (choice == 5)
                facade = new ViewTransactionWithinRange(transactionManager);
            else if (choice == 6)
                facade = new ViewTransacionFromCategory(transactionManager);
            else if (choice == 7)
                facade = new ViewAllTransaction(transactionManager);
            else if (choice == 0)
                exit = true;
        }
    }
}
