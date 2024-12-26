package facade;

import controller.TransactionManager;
import java.util.ArrayList;
import model.Transaction;

public class ViewAllTransaction implements FacadeInterface {

    private ArrayList<Transaction> transactions;

    public ViewAllTransaction(TransactionManager transactionManager, String type) {
        if (type == null || !type.isEmpty()) {
            this.transactions = transactionManager.getAllTransactions();
        } else {
            this.transactions = transactionManager.getFileteredTransaction();
        }
        main();
    }

    public ViewAllTransaction(TransactionManager transactionManager) {
        this.transactions = transactionManager.getAllTransactions();
        main();
    }

    public void main() {

        if(this.transactions.isEmpty()){
            System.out.println("NO TRANSACTION");
            return;
        }
        System.out.println("");
        System.out.println("");

        System.out.printf("ID \t Description \t Amount \t Category \t Date\n");
        System.out.println("========================================================================================");

        // Iterate through each transaction
        for (Transaction transaction : this.transactions) {
            // Assuming Transaction has methods like getId(), getDescription(), etc.
            System.out.printf("%s \t %s \t %.2f \t %s \t %tF\n",
            transaction.getId(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getCategory(),
            transaction.getDate()); // Ensure this is a Date or LocalDate
    
        }
        System.out.println("========================================================================================");
        System.out.println("");
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is view transactions facade");
    }
}
