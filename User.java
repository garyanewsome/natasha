/*
 * User class reads the user.txt file, loads and manages the user data
 */
package natasha;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static natasha.Natasha.print;

/**
 *
 * @author garyanewsome
 */
public class User {
Scanner keyboard = new Scanner(System.in);

  private String name;
  private String pronoun;
  private String filePath;
  private Scanner input = null;
  private List<String> lines;
  private String[] fileLines;

  public User(String filePath) {
    this.name = name;
    this.pronoun = pronoun;
    this.fileLines = null;

    this.filePath = filePath;
    File inputFile = new File(filePath);

    try {
      this.input = new Scanner(inputFile);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PasswordReader.class.getName()).log(Level.SEVERE, null, ex);
    }

    this.lines = new ArrayList();
    while (this.input.hasNext()) {
      String line = this.input.nextLine();
      if (line.charAt(0) != '#') { // excludes commented header lines
        this.lines.add(line);
      }

      for (int i = 0; i < this.lines.size(); i++) {
        fileLines = line.split(";");
      }

    }
  }

  public String getName() {
    this.name = fileLines[0];
    return this.name;
  }

  public String getPronoun() {
    this.pronoun = fileLines[1];
    return this.pronoun;
  }
public String setUser(){
  print("Please enter new user name: ");
this.name = keyboard.nextLine();
print("Please enter your pronoun of choice (ex. Sir or Ma'am): ");
this.pronoun = keyboard.nextLine();

FileWriter userWriter = null;
PrintWriter outFile = null;
try {
    userWriter = new FileWriter("user.txt", false);
    outFile = new PrintWriter(userWriter);
  } catch (IOException ex) {
    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
  }
outFile.println("# User data file");
outFile.println("# name;pronoun;");
outFile.print(this.name + ";" + this.pronoun + ";");
  try {
    userWriter.close();
  } catch (IOException ex) {
    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
  }
 return this.pronoun;

}
}
