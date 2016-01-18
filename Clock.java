/*
 * object to hold basic clock and calaendar functions.
 */
package natasha;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static natasha.Natasha.println;

/**
 *
 * @author garyanewsome
 */
public class Clock {

  public static void getTime() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
    println(sdf.format(cal.getTime()));
  }

  public static void getDate() {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date date = new Date();
    println(dateFormat.format(date));
  }

  public static String getUpdateDate() {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date date = new Date();
    return (dateFormat.format(date));
  }
}
