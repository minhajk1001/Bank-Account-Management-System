
package bank.ams.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BankAMSAdmin {

    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(System.in);
        boolean FurtherAction = true,decision = true;
        while(FurtherAction){
            while(decision){
                System.out.print("1. Transaction\n2. Registration\nEnter : ");
                int transactionOrRegistration = sin.nextInt();
                if(transactionOrRegistration == 1){
                    FileWriting transaction = new FileWriting();
                    System.out.print("Enter Transaction ID: ");
                    int transactionId = sin.nextInt();
                    transaction.depositeOrDithdrawBalance(transactionId);   
                    decision = false;
                }   
                if(transactionOrRegistration == 2){
                    Registration registration = new Registration ();
                    registration.mainMethod();
                    decision = false;
                }
                if(((transactionOrRegistration != 1)&&(transactionOrRegistration !=2)))
                    System.out.println("\n!! Invalid Input !!\n");
            }
            boolean finalAction = true;
            while(finalAction){
                System.out.print("\n1. Run again\n2. Exit\nEnter: ");
                int FurtherActionOrNot = sin.nextInt();
                if(FurtherActionOrNot == 1){
                    System.out.println("\n............New Transaction...............\n");
                    finalAction = false;
                    decision = true;
                }
                if(FurtherActionOrNot == 2){
                    System.out.println("\n.........................................\n");
                    FurtherAction = false;
                    finalAction = false;
                } 
                if((FurtherActionOrNot !=1)&&(FurtherActionOrNot !=2)){
                    System.out.println("\nInvalid Input\n");
                } 
            }    
        }
    }
}
