/*
 * Login class
 * accepts user password input and compares it against the passwords on file
 * this password program is tiered, as an incorrect response to password1
 * triggers password2, and an incorrect response to 2 triggers 3.
 * setPass method allows the user to change the selected password and rewrite
 * the existing file.
 */
package natasha;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static natasha.Natasha.print;
import static natasha.Natasha.println;

/**
 *
 * @author Gary
 */
public class Login implements PassCheck {

  Scanner keyboard = new Scanner(System.in);

  private String[] myPasswords;
  private boolean accepted;
  private String password1;
  private String password2;
  private String password3;
  private String login;

  public Login() {
    this.accepted = false;
    this.password1 = password1;
    this.password2 = password2;
    this.password3 = password3;
    this.login = login;
  }

  public void initializePasswords() {
    PasswordReader passwords = new PasswordReader("./password.txt");
    passwords.readPass();
    myPasswords = passwords.loadPass();
    for (int i = 0; i < myPasswords.length; i++) {
      switch (i) {
        case 0:
          this.password1 = myPasswords[i];
          break;
        case 1:
          this.password2 = myPasswords[i];
          break;
        case 2:
          this.password3 = myPasswords[i];
          break;
      }
    }
  }

  public void setPass() {
    FileWriter passWriter = null;
    PrintWriter outFile = null;

    print("Please choose a password to reset: ");
    int choice = keyboard.nextInt();
    keyboard.nextLine();
    print("Please enter password number " + choice + ": ");
    this.login = keyboard.nextLine();
    if (this.login.equals(myPasswords[choice - 1])) {
      print("Please enter your new password: ");
      String newPass1 = keyboard.nextLine();
      print("Please re-enter your new password: ");
      String newPass2 = keyboard.nextLine();
      if (newPass1.equals(newPass2)) {
        try {
          passWriter = new FileWriter("password.txt", false);
          outFile = new PrintWriter(passWriter);
        } catch (IOException ex) {
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        myPasswords[choice - 1] = newPass1;
        println("Password updated.");
        outFile.println("# User passwords for Natasha program.");
        String updateDate = Clock.getUpdateDate();
        outFile.println("# Last update: " + updateDate);
        for (int i = 0; i < myPasswords.length; i++) {
          outFile.print(myPasswords[i] + ";");
        }
      } else {
        println("Error! Passwords do not match. No update occured.");
      }
    } else {
      println("Incorrect password.");
    }
    try {
      passWriter.close();
    } catch (IOException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public boolean checkPassword() {
    int count = 0;
    initializePasswords();
    do {
      print("Login: ");
      this.login = keyboard.nextLine();
      if (this.login.equals(this.myPasswords[count])) {
        this.accepted = true;
      }
      count++;
    } while (count <= 2 && this.accepted == false);

    return this.accepted;
  }

} // end Login
