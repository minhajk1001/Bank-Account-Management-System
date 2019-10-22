
package bank.ams.admin;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    /*
    * Takes Name, Age, Phone, City from user
    * Generates new user Id
    * Writes all user given information into userId.txt file
    */
    void newUserRegistrationFilrWrite() throws IOException{
        System.out.println("\n......... New User Registration .........\n");
        Scanner sin = new Scanner (System.in);
        String userInputCollectionInArray[] = new String [4];
        for(int i=0; i<4; i++){
            if(i==0)
                System.out.print("Name    : ");
            if(i==1)
                System.out.print("Age     : ");
            if(i==2)
                System.out.print("Phone   : ");
            if(i==3)
                System.out.print("City    : ");
            userInputCollectionInArray[i] = sin.nextLine();
        }
        FileReading fr = new FileReading();
        int newId = fr.countTotalUser() + 1;
        String fileName = newId + "";
        System.out.print("\nNew transcation Id is : " + newId);
        System.out.println();
        System.out.print("Create new password   : ");
        String userPassword = sin.next();
        try{
            File newUserFile = new File ("D:\\Bank AMS\\User Informations\\"+fileName+".txt");
            FileWriter fw = new FileWriter(newUserFile);
            PrintWriter pw = new PrintWriter (fw);
            fw.write(fileName);
            pw.println();
            fw.write(userPassword + "");
            pw.println();
            for(int i=0; i<4; i++){
                fw.write(userInputCollectionInArray[i]);
                pw.println();
            }
            fw.write("100");
            fw.close();
            pw.close();
            System.out.println("\nRegistration has completed.\n\n.........................................");
        }
        catch(FileNotFoundException e){
            System.out.println("Problem Reading file");
        }
    }
    /*
    * update t.0
    he totalUser.txt file when new user registered
    */
    void updateTortalUser() throws IOException{
        try{
            File totalUser = new File("D:\\Bank AMS\\User Informations\\totalUser.txt");
            FileWriter fw = new FileWriter(totalUser, true);
            PrintWriter pw = new PrintWriter(fw);
            FileReading fr = new FileReading();
            int newId = fr.countTotalUser() + 1; 
            File updateTotalUser = new File("D:\\Bank AMS\\User Informations\\totalUser.txt");
            FileWriter fwUpdate = new FileWriter(updateTotalUser, false);
            PrintWriter pwUpdate = new PrintWriter(fwUpdate);
            fwUpdate.write(newId + "");
            fwUpdate.close();
            pwUpdate.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Problem While Writing files");
        }
    }
    /*
    * deposite Or withdraw balance
    */
    void depositeOrDithdrawBalance(int transactionId) throws IOException{
        Scanner sin = new Scanner(System.in);
        System.out.println("\n.........................................\n\nTransaction Id is: " + transactionId +"\n");
        File fileTransactionId = new File("D:\\Bank AMS\\User Informations\\"+transactionId + ".txt");
        FileWriter fw = new FileWriter(fileTransactionId, true);
        PrintWriter pw = new PrintWriter(fw);
        FileReading fwing = new  FileReading();
        String userDetailsArray[] = new String[7];
        userDetailsArray = fwing.userDetails(transactionId);
        File UpdateFileTransactionId = new File("D:\\Bank AMS\\User Informations\\"+transactionId + ".txt");
        FileWriter fwUpdate = new FileWriter(UpdateFileTransactionId, false);
        PrintWriter pwUpdate = new PrintWriter(fwUpdate);
        int balance = Integer.parseInt(userDetailsArray[6]);
        boolean decision = true;
        while(decision){
            System.out.print("1. Deposite\n2. Withdraw\n3. Cancel\nEnter: ");
            int depositeOrWithDraw = sin.nextInt();
            if(depositeOrWithDraw == 1){
                System.out.print("\nEnter balance: ");
                int depositeOrWithDrawBalance = sin.nextInt();
                balance = balance + depositeOrWithDrawBalance;
                userDetailsArray[6] = balance + "";
                decision = false;
            }   
            if(depositeOrWithDraw == 2){
                System.out.println("\nAccess Denied!\n\n.........................................\n");      
            }
            if(depositeOrWithDraw == 3)
                decision = false;
            if(((depositeOrWithDraw != 1)&&(depositeOrWithDraw !=2)&&(depositeOrWithDraw !=3)))
                System.out.println("\n!! Invalid Input !!");
        }
        for(int i=0; i<7; i++){
            fwUpdate.write(userDetailsArray[i] + "");
            pwUpdate.println();
        }
        System.out.println("\nTransaction has completed.\n\n.........................................");
        fw.close();
        pw.close();
        fwUpdate.close();
        pwUpdate.close();
    }
}
