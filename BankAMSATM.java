
package bank.ams.atm;

import java.io.IOException;
import java.util.Scanner;

public class BankAMSATM {

    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner (System.in);
        System.out.print("...... Welcome to Our Banking System ......\n\nID      : ");
        String userId = sin.next();
        FileReading fr = new FileReading();
        fr.showUserDetails(userId + "");
    }
    
}
