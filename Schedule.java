import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Schedule class reads a text file that contains the train schedule and stores the schedule into an array of our Train model
 *
 * @author Nick Coyle
 * @version 11.7.2018
 */
public class Schedule
{
    private Train[] trains;
    private int distance;
    
    Schedule(String fileName) throws FileNotFoundException {
        fillArray(fileName);
    }
    
    public void fillArray(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));        
        
        distance = scanner.nextInt();
        int size = scanner.nextInt();
                
        for(int i = 0; i < size; ++i) {
            String name = scanner.nextLine();
            int departureHour = scanner.nextInt();
            int departureMinute = scanner.nextInt();
            int arrivalHour = scanner.nextInt();
            int arrivalMinute = scanner.nextInt();
            Train train = new Train(name, new Time(departureHour, departureMinute), new Time(arrivalHour, arrivalMinute), distance);
            trains[i] = train;
        }
    }
    
    public Train fastestTrain() {
        
        return trains[trains.length-1];
    }
    
    public void sortDeparture() {
        
    }
    
    @Override
    public String toString() {
        String str = "";
        return str;
    }
    
}
