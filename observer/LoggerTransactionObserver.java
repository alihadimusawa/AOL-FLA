package observer;

import model.Transaction;

public class LoggerTransactionObserver implements TransactionObserver{

    @Override
    public void onTransactionAdded(Transaction transaction) {
        // TODO Auto-generated method stub
        System.out.println("Transaction added: " + transaction);
    }

    @Override
    public void onTransactionRemoved(Transaction transaction) {
        // TODO Auto-generated method stub
        System.out.println("Transaction removed: " + transaction);
    }
    
}
