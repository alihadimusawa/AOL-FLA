package factory;

import java.util.Random;
import model.Transaction;

public class TransactionFactory implements Factory<Transaction> {

    @Override
    public Transaction create(String description, double amount, String category) {
        String id = generateId();
        Transaction createdTransaction = new Transaction(id, description, amount, category);

        // Log a success message
        System.out.println("New transaction has been created successfully: " + createdTransaction);

        return createdTransaction;
    }

    @Override    
    public String generateId() {
        String prefix = "TA";
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900); 
        return prefix + randomNumber; 
        // Example output: "TA421"
    }
}
