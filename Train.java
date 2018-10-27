
/**
 * Write a description of class Time here.
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

    Train() {
        this("", new Time(), new Time(), 0);
    }

    Train(String name, Time departure, Time arrival, int distance) {
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
    }

    public Time getDeparture () {
        return departure;
    }

    public Time getArrival () {
        return arrival;
    }

    public int getDistance () {
        return distance;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;   
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

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
        Time travelTime = travelTime();
        double hours = travelTime.getHour() + (double)travelTime.getMinute()/60;
        return (int)(distance / hours);
    }

    /**
     * method to calculate the amount of time the Train travelled
     * this is calculated using the timeBetween() method of the Time class
     */
    public Time travelTime() {        
        return departure.timeBetween(arrival);
    }

    @Override
    public String toString() {
        String str = name + "\n";
        str += "Departure             " + departure + "\n";
        str += "Arrival               " + arrival + "\n";
        str += "Travel Time           " + travelTime() + "\n";
        str += "Average Speed         " + averageSpeed() + "km/h" + "\n";
        
        return str;
    }
    
    public static void test() {
        Train test = new Train();
        Train test2 = new Train("testy", new Time(8, 30), new Time(9, 45), 1000);
        
        if(!test2.name.equals("testy")) System.out.println("Should be \"testy\" but was" + test2.name);
        if(test2.travelTime().getHour() != 1) System.out.println("Traveltime hours should be 1 but was" + test2.travelTime().getHour());
        if(test2.travelTime().getMinute() != 15) System.out.println("Traveltime minutes should be 15 but was" + test2.travelTime().getMinute());
    }
}
