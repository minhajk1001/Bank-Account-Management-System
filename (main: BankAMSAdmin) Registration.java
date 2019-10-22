
package bank.ams.admin;

import java.io.IOException;

public class Registration {
    public void mainMethod() throws IOException{
        FileWriting fw = new FileWriting();
        fw.newUserRegistrationFilrWrite();
        fw.updateTortalUser();
    }
}
