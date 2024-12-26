package controller;

import java.time.LocalDate;
import java.util.*;
import model.*;

public class TransactionManager {

    private ArrayList<Transaction> transactions;
    private ArrayList<Transaction> filteredTransactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(String transactionId) {
        for (Transaction transaction : transactions) {
            if(transaction.getId().equals(transactionId)){
                transactions.remove(transaction);
                System.out.println("Transaction removed successuflly");
                return;
            }
        }
        System.out.println("Transaction not found");
    }

    public double calculateTotalIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getAmount());
            if (transaction.getAmount() > 0) {
                totalIncome += transaction.getAmount();
            }
        }
        return totalIncome;
    }

    public double calculateTotalExpense() {
        double totalExpense = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println("True");
                totalExpense += transaction.getAmount();
            }
        }
        return totalExpense;
    }

    public boolean getTransactionsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        filteredTransactions = new ArrayList<>(); // Ensure this list is reset each time.
    
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
    
            // Debug: Print dates being compared
            System.out.printf("Checking transaction date: %s against range %s to %s\n",
                    transactionDate, startDate, endDate);
    
            // Check if transactionDate is within range
            if ((transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate)) 
                    && (transactionDate.isEqual(endDate) || transactionDate.isBefore(endDate))) {
                filteredTransactions.add(transaction);
                found = true;
            }
        }
    
        this.filteredTransactions = filteredTransactions;
        return found;
    }
    
    

    public boolean getTransactionsByCategory(String category) {
        
        boolean found = false;

        ArrayList<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                filteredTransactions.add(transaction);
                found = true;
            }
        }
        this.filteredTransactions = filteredTransactions;
        return found;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return transactions;
    }

    public ArrayList<Transaction> getFileteredTransaction(){
        return filteredTransactions;
    }
}
