package c2;

import java.util.Date;

/** The first Thinking in Java example program
 * Displays a string and today's date.
 * @author doordiey
 * @version 1.0
 */

public class HelloDate {
    /**
     * Entry point to class & application.
     * @param args array of string arguments

     */
    public static void main(String[] args){
        System.out.println("Hello,it's:");
        System.out.print(new Date());
    }
}
