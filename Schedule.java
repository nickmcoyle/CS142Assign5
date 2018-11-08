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

    /**
     * A method to initialize the trains instance field by reading values from a text file
     * 
     * @params fileName:String a String containing the name of the file to read
     */
    public void fillArray(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));        

        distance = scanner.nextInt();
        scanner.nextLine();
        int size = scanner.nextInt(); 
        trains = new Train[size];               

        //I dont like while loop here because if the file has one or more empty lines after the last train,
        //then it will continue reading them and an exception will be thrown 
        //plus this is not an indefinite loop, we know how many trains to read
        for(int i = 0; i < size; ++i) {
            scanner.nextLine();
            String name = scanner.nextLine();
            int departureHour = scanner.nextInt();           
            int departureMinute = scanner.nextInt();
            scanner.nextLine();
            int arrivalHour = scanner.nextInt();            
            int arrivalMinute = scanner.nextInt();

            Train train = new Train(name, new Time(departureHour, departureMinute), new Time(arrivalHour, arrivalMinute), distance);
            trains[i] = train;           
        }
    }

    /** 
     * A method to tell us the train with the lowest travel time calculated using time of departure and time of arrival.
     * 
     * @return Train the train with the fastest traveltime
     */
    public Train fastestTrain() {
        int iFastest = 0;

        for(int i = 1; i < trains.length; ++i) {
            Time fastest = trains[iFastest].travelTime();
            Time next = trains[i].travelTime();

            if((next.getHour() * 60 + next.getMinute()) < (fastest.getHour() * 60 + fastest.getMinute())) 
            {
                iFastest = i;
            }
        }

        Train fastest = trains[iFastest];
        return fastest;
    }

    /**
     * Method to sort the trains by departure time earliest to latest.
     * Just a basic selection sort.
     */
    public void sortDeparture() {        
        int iMin;

        for(int i = 0; i < trains.length - 1; ++i)
        {
            iMin = i;

            for(int j = i + 1; j < trains.length; ++j)
            {
                Time earliest = trains[iMin].getDeparture();
                Time next = trains[j].getDeparture();
                if((next.getHour() * 60 + next.getMinute()) < (earliest.getHour() * 60 + earliest.getMinute())) {
                    iMin = j;   
                }
            }

            if(iMin != i) {
                Train temp = trains[i];
                trains[i] = trains[iMin];
                trains[iMin] = temp;        
            }
        }
    }

    /**
     * Method to save the schedule to a String
     * 
     * @return Returns a String with our formatted text
     */
    @Override
    public String toString() {
        String output = "";

        for(int i = 0; i < trains.length; ++i) {        
            output += trains[i].toString();
        }

        return output;
    }

    /**
     * A test method that is necessary because it is not possible to debug the Schedule class when using the ScheduleApp class 
     */
    public static void test() throws FileNotFoundException {        
        Schedule schedule;
        schedule = new Schedule("trains.txt");
        schedule.sortDeparture();
        System.out.println(schedule.toString());
        System.out.println("The fastest train:");
        System.out.println(schedule.fastestTrain().toString() + "\n");
    }
}
