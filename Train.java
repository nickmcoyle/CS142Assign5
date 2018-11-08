
/**
 * Train class models a train with its name, traveltime, distance, and the time it leaves and arrives
 *
 * @author Nick Coyle
 * @version 10.29.2018
 */
public class Train
{
    private String name;    
    private Time departure;
    private Time arrival;
    private int distance;  
    private int speed;
    
    Train(String name, Time departure, Time arrival, int distance) {
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;                
        this.speed = averageSpeed();
    }

    /**
     * A method to get the departure time.
     * 
     * @return Time departure time
     */
    public Time getDeparture () {
        return departure;
    }

    /**
     * A method to get the time of arrival.
     * 
     * @return Time arrival time
     */
    public Time getArrival () {
        return arrival;
    }

    /**
     * A method to get the distance of travel for the train.
     * 
     * @return int the distance traveled
     */
    public int getDistance () {
        return distance;
    }

    /**
     * A method to set the departure time.
     * 
     * @params departure:Time the time of departure
     */
    public void setDeparture(Time departure) {
        this.departure = departure;   
    }

    /**
     * A method to set the arrival time.
     * 
     * @params arrival:Time the time of arrival
     */
    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }
    
    /**
     * A method to set the distance traveled.
     * 
     * @params distance:int the distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * method to calculate the average speed a Train travelled using the distance and total time of travel
     * this is calculated using the formula distance = rate*time
     */
    public int averageSpeed() {
        //distance = rate * time
        //rate = distance / time;
        double minutes = (travelTime().getHour() * 60) + travelTime().getMinute();
        int speed = (int)(distance / (minutes / 60));
        
        return speed;
    }

    /**
     * method to calculate the amount of time the Train travelled
     * this is calculated using the timeBetween() method of the Time class
     */
    public Time travelTime() {        
        return departure.timeBetween(arrival);
    }

    /**
     * A method to save the train to a String
     * 
     * @return Returns a String with our formatted text
     */
    @Override
    public String toString() {
        String str = name + "\n";
        str += "Departure\t" + departure + "\n";
        str += "Arrival\t" + arrival + "\n";
        str += "Travel Time\t" + travelTime() + "\n";
        str += "Average Speed\t" + speed + "km/h" + "\n";
        str += "\n";
        
        return str;
    }
    
    public static void test() {        
        Train test2 = new Train("testy", new Time(8, 30), new Time(9, 45), 1000);
        
        if(!test2.name.equals("testy")) System.out.println("Should be \"testy\" but was " + test2.name);
        if(test2.travelTime().getHour() != 1) System.out.println("Traveltime hours should be 1 but was " + test2.travelTime().getHour());
        if(test2.travelTime().getMinute() != 15) System.out.println("Traveltime minutes should be 15 but was " + test2.travelTime().getMinute());
        if(test2.averageSpeed() != 800) System.out.println("Test train average speed should be 800km/h but was " + test2.averageSpeed());
        
        Train nightExpress = new Train("Night Express", new Time(23,55), new Time(8,15), 650);
        if(!nightExpress.name.equals("Night Express")) System.out.println("nightExpress name should be \"Night Express\" but was " + nightExpress.name);
        if(nightExpress.travelTime().getHour() != 8) System.out.println("nightExpress traveltime hours should be 8 but was " + nightExpress.travelTime().getHour());
        if(nightExpress.travelTime().getMinute() != 20) System.out.println("nightExpress traveltime minutes should be 20 but was " + nightExpress.travelTime().getMinute());
        if(nightExpress.averageSpeed() != 78) System.out.println("nightExpress train average speed should be 78km/h but was " + nightExpress.speed);
    }
}
