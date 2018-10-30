
/**
 * Time class models a custom Time object that holds hours and minutes in European time format i.e. 24 hour time or military time. 
 *
 * @author Nick Coyle
 * @version 10.29.2018
 */
public class Time
{
    private int minute;
    private int hour;
    
    Time() {
        this(0,0);
    }
    
    Time(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        if(hour < 0 && hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23 inclusive");
        }
        
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if(hour < 0 && hour > 60) {
            throw new IllegalArgumentException("Minute must be between 0 and 60 inclusive");
        }
        
        this.minute = minute;
    }    

    /*
     * method to calculate the amount of hour and minutes difference between two times
     * 
     * @param Time other is the Time object that we will be comparing the current Time object to
     */
    public Time timeBetween(Time other) {
        int hours = other.getHour() - this.getHour();
        int minutes = other.getMinute() - this.getMinute();
        
        if (hours < 0) {
            hours += 24;
        }
        
        if(minutes < 0) {
            minutes += 60;
            --hours; 
        } 
               
        return new Time(hours, minutes);
    }

    /*
     * method to format the hour or minute component of a Time object to make it display better
     * 
     * @param int timePart is the hour or minute we will format
     */
    public String zeroTime(int timePart) {
        String timeString =  Integer.toString(timePart);
        
        if(timePart >= 0 && timePart <= 9) {
            timeString = "0" + timePart;
        }
        
        return timeString;
    }

    @Override
    public String toString() {
        return new String(zeroTime(hour) + ":" + zeroTime(minute));
    }
    
    public static void test() {
        Time test = new Time();
        if(test.getHour() != 0) System.out.println("Should be 0 but was " + test.getHour());
        if(test.getMinute() != 0) System.out.println("Should be 0 but was " + test.getMinute());
                
        Time test2 = new Time(8, 30);
        if(test2.getHour() != 8) System.out.println("Should be 8 but was " + test2.getHour());
        if(test2.getMinute() != 30) System.out.println("Should be 30 but was " + test2.getMinute());
        if(!test2.zeroTime(test2.getHour()).equals("08")) System.out.println("zeroTime string of 8 Should be 08 but was " + test2.zeroTime(test2.getHour()));
        
        Time timeBtn = test.timeBetween(test2);
        if(timeBtn.getHour() != 8) System.out.println("Hour of time between 00:00 and 8:30 should be 8 but was " + timeBtn.getHour());
        if(timeBtn.getMinute() != 30) System.out.println("Minute of time between 00:00 and 8:30 should be 30 but was " + timeBtn.getHour());
        
        
        Time eightFifteen = new Time(8,15);
        if(eightFifteen.getHour() != 8) System.out.println("eightFifteen hour should be 8 but was " + eightFifteen.getHour());
        if(eightFifteen.getMinute() != 15) System.out.println("eightFifteen minute should be 15 but was " + eightFifteen.getMinute());
        
        Time twentyThreeFiftyFive = new Time(23, 55);
        if(twentyThreeFiftyFive.getHour() != 23) System.out.println("twentyThreeFiftyFive hour should be 23 but was " + twentyThreeFiftyFive.getHour());
        if(twentyThreeFiftyFive.getMinute() != 55) System.out.println("twentyThreeFiftyFive minute should be 55 but was " + twentyThreeFiftyFive.getMinute());
        
        Time timeBtn2 = twentyThreeFiftyFive.timeBetween(eightFifteen);
        if(timeBtn2.getHour() != 8) System.out.println("Hour of time between 23:55 and 8:15 should be 8 but was " + timeBtn2.getHour());
        if(timeBtn2.getMinute() != 20) System.out.println("Minute of time between 23:55 and 8:15 hould be 20 but was " + timeBtn2.getHour());
        
    }

}
