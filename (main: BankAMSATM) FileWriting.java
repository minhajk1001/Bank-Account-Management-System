
package bank.ams.atm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWriting extends FileReading{
    void updateBalance(String transactionId) throws IOException{
        File fileTransactionId = new File("D:\\Bank AMS\\User Informations\\"+transactionId + ".txt");
        FileWriter fw = new FileWriter(fileTransactionId, true);
        PrintWriter pw = new PrintWriter(fw);
        FileReading fwing = new  FileReading();
        Scanner sin = new Scanner(System.in);
        Scanner transactionIdTxt = new Scanner(fileTransactionId);
        String userDetails[] = new String[7];
        for(int i=0; i<7; i++)
            userDetails[i] = transactionIdTxt.nextLine();
        File UpdateFileTransactionId = new File("D:\\Bank AMS\\User Informations\\"+transactionId + ".txt");
        FileWriter fwUpdate = new FileWriter(UpdateFileTransactionId, false);
        PrintWriter pwUpdate = new PrintWriter(fwUpdate);
        int balance = Integer.parseInt(userDetails[6]);
        boolean decision = true;
        while(decision){
            System.out.println();
            System.out.print("...........................................\n\n1. Show Balance\n2. Withdraw\nEnter: ");
            int showDetailsOrTransaction = sin.nextInt();
            System.out.println();
            if(showDetailsOrTransaction == 1){
                System.out.print("Current Balance: "+userDetails[6]+" $\n\n...........................................\n\n1. Another Transaction\n2. Exit\nEnter: ");
                boolean decison2 = true;
                while(decison2){
                    int AnotherTraOrNot = sin.nextInt();
                    if(AnotherTraOrNot == 1)
                        decison2 = false;
                    if(AnotherTraOrNot == 2){
                        decision = false;
                        decison2 = false;
                    }
                    if(((AnotherTraOrNot != 1)&&(AnotherTraOrNot !=2))){
                        System.out.println("\n............. Invalid Input ...............\n");
                        System.out.print("1. Another Transaction\n2. Exit\nEnter: ");
                    }   
                }
            }   
            if(showDetailsOrTransaction == 2){
                System.out.print("Enter balance: ");
                int withdrawAmount = sin.nextInt();
                if(withdrawAmount<balance){
                    balance = balance - withdrawAmount;
                    userDetails[6] = balance + "";
                    decision = false;
                    System.out.println("\n...........................................\n\nNew Balance: "+userDetails[6]+" $");
                }
                else{
                    System.out.println("\n...........................................\n\nNot enough balance.\nCurrent balance: " + balance+" $");
                    System.out.println();
                    boolean cancelTransaction = true;
                    while(cancelTransaction){
                        System.out.print("...........................................\n\n1. Another Transaction\n2. Cancel Transaction\nEnter: ");
                        int cancelOrNot = sin.nextInt();
                        if(cancelOrNot == 1){
                            decision = true;
                            cancelTransaction = false;
                        }
                        if(cancelOrNot == 2){
                            decision = false;
                            cancelTransaction = false;
                        }
                        if((cancelOrNot != 1)&&(cancelOrNot != 2))
                            System.out.println("\n............. Invalid Input ...............n");
                    }
                }      
            }
        }
        for(int i=0; i<7; i++){
            fwUpdate.write(userDetails[i] + "");
            pwUpdate.println();
        }
        System.out.println("\n........ Transaction has completed ........\n");
        fw.close();
        pw.close();
        fwUpdate.close();
        pwUpdate.close();
    }
}
