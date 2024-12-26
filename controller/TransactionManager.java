package controller;

import java.time.LocalDate;
import java.util.*;
import model.*;
import observer.TransactionObserver;

public class TransactionManager {

    private ArrayList<Transaction> transactions;
    private List<TransactionObserver> observers = new ArrayList<TransactionObserver>();

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void addObserver(TransactionObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TransactionObserver observer){
        observers.remove(observer);
    }

    private void notifyTransactionAdded(Transaction transaction){
        for (TransactionObserver observer : observers){
            observer.onTransactionAdded(transaction);
        }
    }

    private void notifyTransactionRemoved(Transaction transaction){
        for (TransactionObserver observer : observers){
            observer.onTransactionRemoved(transaction);
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyTransactionAdded(transaction);
    }

    public Transaction findTransactionById(String transactionId){
        for(Transaction transaction : transactions){
            if(transaction.getId().equals(transactionId)){
                return transaction;
            }
        }

        return null;
    }

    public boolean removeTransaction(String transactionId) {
        Transaction transaction = findTransactionById(transactionId);

        if(transaction !=null){
            transactions.remove(transaction);
            notifyTransactionRemoved(transaction);
            return true;
        }

        //return transactions.removeIf(t -> t.getId() == transactionId);
        return false;
    }

    public double calculateTotalIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
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
                totalExpense += transaction.getAmount();
            }
        }
        return totalExpense;
    }

    public List<Transaction> getTransactionsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().compareTo(startDate) >= 0 && transaction.getDate().compareTo(endDate) <= 0) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return transactions;
    }
}
