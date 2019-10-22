
package bank.ams.user;

import java.io.*;
import java.util.Scanner;

public class FileReading {
    /*
    * copy useId.txt in userDetailsArray[];
    * show user details
    */
    void showUserDetails(String userId) throws IOException{
        File file = new File("D:\\Bank AMS\\User Informations\\"+userId + ".txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        Scanner sin = new Scanner(file);
        String userDetails[] = new String[7];
        for(int i=0; i<7; i++)
            userDetails[i] = sin.nextLine();
        Scanner sinUsePassword = new Scanner(System.in);
        boolean decision = true;
        while(decision){
            System.out.print("Password: ");
            String userPassword = sinUsePassword.next();
            if(userPassword.equals(userDetails[1])){
                for(int i=0; i<7; i++){
                    if(i==0)
                        System.out.print("\n.............. User Details ................\n\nID      : ");
                    if(i==1)
                        continue; //don't show the password
                    if(i==2)
                        System.out.print("Age     : ");
                    if(i==3)
                        System.out.print("Name    : ");
                    if(i==4)
                        System.out.print("Phone   : ");
                    if(i==5)
                        System.out.print("City    : ");
                    if(i==6){
                        System.out.println("Balance : "+userDetails[i]+" $");
                        break;
                    }
                    System.out.println(userDetails[i]);
                }
                decision = false;
            }
            else{
                System.out.println("\n.............. Wrong Password ..............\n");
            }
        }
        System.out.println("\n......... Trasaction Has Completed .........\n");
    }
}
