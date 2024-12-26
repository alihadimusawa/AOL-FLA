package facade;

import factory.Factory;
import factory.TransactionFactory;
import java.util.*;
import model.Transaction;

public class AddTransaction implements FacadeInterface{

    public AddTransaction() {
    }

    public Transaction main() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a Transaction");

        String description;
        double amount;

        while (true) {
            System.out.print("Enter transaction description: ");
            description = scanner.nextLine();
            if(!description.isEmpty()){
                break;
            }
        }

        while (true) {
            System.out.print("Enter transaction amount: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); 
            }
        }

        System.out.print("Enter transaction category: ");
        String category = scanner.nextLine();

        Factory<Transaction> factory = new TransactionFactory();
        Transaction transaction = factory.create(description, amount, category);

        return transaction;
    }

    @Override
    public void check() {
        System.out.println("This is add transaction facade");
    }

}
