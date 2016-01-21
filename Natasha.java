/*
 * Natasha - A concept turned notion
 * of a personal project of a personal assistant program.
 *
 * Real purpose: Java practice and exploration, and one never knows.
 * 
 * Natasha version number documentation... x.y.z.
 * x = serious version number, y = beta version number, z = session update number
 *
 * Current Fucntions: Login, Admin, Sys Admin, Date, Time, set Password, set User
 * Updates this version: load and set User data, Sys Admin protocols
 *
 */
package natasha;

import java.util.Scanner;

/**
 *
 * @author garyanewsome
 */
public class Natasha {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); // initialize Scanner
    
    // check to see if last login was successful and run system admin login if not.
    SysAdmin sysAd = new SysAdmin("./sysadmin.txt");
    boolean goodToGo = sysAd.checkLast();
    if(!goodToGo){
      sysAd.Login();
    }

    // constant representing system name and version number
    final String V = "Natasha v.0.1.3";

    // create user variables, and load data from User class
    String name;
    String pronoun;
    User user = new User("./user.txt");
    user.loadUser();
    name = user.getName();
    pronoun = user.getPronoun();

    println(V);
    println(name);

    // create new login instance and check user password
    Login login = new Login();
    boolean accepted = login.checkPassword();

    if (accepted) {
      print("\nWelcome " + pronoun + ", the current time is ");
      Clock.getTime();
      println(".");
    } else {
      println("Login FAILURE!");
      Admin admin = new Admin();
      accepted = admin.checkPassword();
      if (accepted) {
        Clock.getDate();
        println("\nAdmin priveledges available soon.");
      } else {
        println("Goodbye.");
      }
    }
    sysAd.writeLast(accepted);
    
    while (accepted){
      int selection = menu(accepted, keyboard, pronoun);

      switch (selection) {
        case 0:
          println("Have a pleasant day " + pronoun);
          System.exit(0);
          break;
        case 1:
          println("Coming soon...");
          break;
        case 2:
          Clock.getDate();
          break;
        case 3:
          Admin admin = new Admin();
          if (accepted) {
            login.setPass();
          }
          break;
        case 4:
          pronoun = user.setUser();
          println(pronoun + " please reboot the system for the user"
                  + " changes to take effect.");
      }
      }

      // footer
      println("\n" + V);
    } // end main


  public static int menu(boolean accepted, Scanner keyboard, String pronoun) {
    println("1: Zander program (coming soon)");
    println("2: Current date and time.");
    println("3: Set password");
    println("4: Set user");
    println("0: Exit");
    println("");
    print("You selection " + pronoun + ": ");
    int selection = keyboard.nextInt();
    return selection;
  } // end menu

  public static void print(String msg) {
    System.out.print(msg);
  } // end print

  public static void println(String msg) {
    System.out.println(msg);
  } // end println

}
