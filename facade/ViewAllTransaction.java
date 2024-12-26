package facade;

import controller.TransactionManager;
import java.util.ArrayList;
import model.Transaction;

public class ViewAllTransaction implements FacadeInterface{

    private ArrayList<Transaction> transactions; 
    private TransactionManager transactionManager; 
    
    public ViewAllTransaction(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.transactions = transactionManager.getAllTransactions();
    }

    public void main() {
        System.out.printf("ID \t Description \t Amount \t Category\n");
        System.out.println("======================================================");

        // Iterate through each transaction
        for (Transaction transaction : this.transactions) {
            // Assuming Transaction has methods like getId(), getDescription(), etc.
            System.out.printf("%s \t %s \t %.2f \t %s\n", 
                              transaction.getId(), 
                              transaction.getDescription(), 
                              transaction.getAmount(), 
                              transaction.getCategory());
        }
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is view transactions facade");
    }
}
