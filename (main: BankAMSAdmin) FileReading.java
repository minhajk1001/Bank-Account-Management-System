
package bank.ams.admin;

import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

public class FileReading {
    /*
    * read totalUser.Txt file 
    * returns the number of total user
    */
    int countTotalUser() throws IOException{
    File file = new File("D:\\Bank AMS\\User Informations\\totalUser.Txt");
    FileWriter fw = new FileWriter (file, true);
    PrintWriter pw = new PrintWriter (fw);
    Scanner sin = new Scanner (file);
    String totalUserTxt = sin.next();
    int totalUserInt = Integer.parseInt(totalUserTxt);
    int idArrayLength = 0;
    while(sin.hasNext()){
        idArrayLength ++;
        sin.next();
    }
    return totalUserInt;
    }
    /*
    * read userId.txt file
    * copy userId.txt file into userDetailsArray[]
    */
    String[] userDetails(int transactionId) throws IOException{
        String userDetailsArray[] = new String[7];
        File file = new File("D:\\Bank AMS\\User Informations\\"+transactionId + ".txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        Scanner sin = new Scanner(file);
        for(int i=0; i<7; i++)
            userDetailsArray [i] = sin.nextLine();
        return userDetailsArray;
    }
}
