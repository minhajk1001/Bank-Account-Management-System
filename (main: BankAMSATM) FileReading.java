
package bank.ams.atm;

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
        boolean decision = true;
        while(decision){
            System.out.print("Password: ");
            Scanner user = new Scanner(System.in);
            String userPassword = user.next();
            if(userPassword.equals(userDetails[1])){
                FileWriting fwing = new FileWriting();
                fwing.updateBalance(userId);
                decision = false;
            }
            else
                System.out.println("\n............. Wrong Password! ...............\n");
        }
    }
}
