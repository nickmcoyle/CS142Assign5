
/**
 * Write a description of class Main here.
 *
 * @author Nick Coyle
 * @version 10.29.2018
 */
import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) {
        Train nightExpress = new Train("Night Express", new Time(23,55), new Time(8,15), 650);
        System.out.println(nightExpress);

        Time.test();
        Train.test();
        
        try {
            Schedule.test();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
