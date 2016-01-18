/*
 * Admin class.
 * Allows an admin password to log in after standard user login failed.
 */
package natasha;

import java.util.Scanner;
import static natasha.Natasha.print;
/**
 *
 * @author Gary
 */
public class Admin implements PassCheck {
  private String adminPass;
  private String admin;
  private boolean adminAccepted;
  
  public Admin(){
    this.adminPass = "admin";
    this.admin = admin;
    this.adminAccepted = false;
  }
  
  @Override
  public boolean checkPassword(){
    Scanner keyboard = new Scanner(System.in);
    int count = 0;
    do{
      print("Admin: ");
      this.admin = keyboard.nextLine();
      if(admin.equals(adminPass)){
        this.adminAccepted = true;
      }
      count++;
    }while(!this.admin.equals(this.adminPass) && count < 2);
    
      
    return adminAccepted;
  }
} // end Admin
