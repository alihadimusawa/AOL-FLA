package facade;

import controller.TransactionManager;

public class CalculateTotalIncome implements FacadeInterface{

    TransactionManager transactionManager;

    public CalculateTotalIncome(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
        main();
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is calculate total income");
    }

    @Override
    public void main() {
        System.out.println("");
        System.out.println("Calculate Total Income");

        double totalExpense = this.transactionManager.calculateTotalIncome();
        System.out.println("Total Income: " + totalExpense);
    }
    
}
