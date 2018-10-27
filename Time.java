
/**
 * Write a description of class Time here.
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
        if(hour < 0 && hour > 12) {
            throw new IllegalArgumentException("Hour must be between 0 and 12 inclusive");
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
        int hours = Math.abs(this.hour - other.hour);
        int minutes = Math.abs(this.minute - other.minute); 
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
        if(test.getHour() != 0) System.out.println("Should be 0 but was" + test.getHour());
        if(test.getMinute() != 0) System.out.println("Should be 0 but was" + test.getMinute());
        
        Time test2 = new Time(8, 30);
        if(test2.getHour() != 8) System.out.println("Should be 8 but was" + test2.getHour());
        if(test2.getMinute() != 30) System.out.println("Should be 30 but was" + test2.getMinute());
        
        Time timeBtn = test.timeBetween(test2);
        if(timeBtn.getHour() != 8) System.out.println("Should be 8 but was" + timeBtn.getHour());
        if(timeBtn.getMinute() != 30) System.out.println("Should be 30 but was" + timeBtn.getHour());
        
    }

}
