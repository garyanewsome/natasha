/*
 * System Admin Login Class
 * Reads a file to determine if the last login was successful
 * If last login was successful the program will default to the login screen
 * if previous login and admin login failed, SysAdmin will load.
 */
package natasha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static natasha.Natasha.print;

/**
 *
 * @author Gary
 */
public class SysAdmin {

  Scanner keyboard = new Scanner(System.in);

  private String filePath;
  private Scanner input = null;
  private String lastLogin;
  private String sysLogin;

  public SysAdmin(String filePath) {
    this.filePath = filePath;
    File inputFile = new File(filePath);
    this.lastLogin = lastLogin;
    this.sysLogin = "sysAd";

    try {
      this.input = new Scanner(inputFile);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PasswordReader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public boolean checkLast() {
    boolean goodToGo = true;
    while (this.input.hasNext()) {
      this.lastLogin = this.input.nextLine();
      if (this.lastLogin.equals("FAIL")) {
        goodToGo = false;
      }

    }
    return goodToGo;
  }

  public void Login() {
    print("System Admin: ");
    String login = keyboard.nextLine();
    if (!this.sysLogin.equals("sysAd")) {
      System.exit(0);
    }
  }

  public void writeLast(boolean accepted) {
    FileWriter lastWriter = null;
    PrintWriter outFile = null;

    try {
      lastWriter = new FileWriter("sysadmin.txt", false);
      outFile = new PrintWriter(lastWriter);
    } catch (IOException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    outFile.println("# System Admin login class file");
    outFile.println("# PASS / FAIL");
    if (accepted) {
      outFile.println("PASS");
    } else {
      outFile.println("FAIL");
    }
    try {
      lastWriter.close();
    } catch (IOException ex) {
      Logger.getLogger(SysAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
