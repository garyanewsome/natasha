/*
 * This class read the contents of the password.txt file
 * method readPass, reads the file and loads the content into an array
 * method loadPass, tokenizes the contents of the line and loads it into an array
 *    returns the array to the Login class
 */
package natasha;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gary
 */
public class PasswordReader {

  private String filePath;
  private Scanner input = null;
  private List<String> lines;

  public PasswordReader(String filePath) {
    this.filePath = filePath;
    File inputFile = new File(filePath);

    try {
      this.input = new Scanner(inputFile);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PasswordReader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void readPass() {
    this.lines = new ArrayList();
    while (this.input.hasNext()) {
      String line = this.input.nextLine();
      if (line.charAt(0) != '#') { // excludes commented header lines
        this.lines.add(line);
      }
    }
  }

  public String[] loadPass() {
    String[] fileLines = null;
    for (String line : this.lines) {
      fileLines = line.split(";");
    }
    return fileLines;
  }
}
