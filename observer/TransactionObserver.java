package observer;

import model.Transaction;

public interface TransactionObserver{
    void onTransactionAdded(Transaction transaction);
    void onTransactionRemoved(Transaction transaction);
}