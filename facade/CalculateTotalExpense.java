package facade;

import java.util.Scanner;

import controller.TransactionManager;

public class CalculateTotalExpense implements FacadeInterface{
    TransactionManager transactionManager;
    public CalculateTotalExpense(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
        main();
    }

    public void main(){
        System.out.println("");
        System.out.println("Calculate Total Expense");

        double totalExpense = this.transactionManager.calculateTotalExpense();
        System.out.println("Total Expense: " + totalExpense);
    
    }

    @Override
    public void check() {
        // TODO Auto-generated method stub
        System.out.println("This is calculate total expense");
    }
}
