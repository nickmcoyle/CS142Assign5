
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
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }    

    /*
     * method to calculate the amount of hour and minutes difference between two times
     * 
     * @param Time other is the Time object that we will be comparing the current Time object to
     */
    public Time timeBetween(Time other) {
        return new Time();
    }

    /*
     * method to format the hour or minute component of a Time object to make it display better
     * 
     * @param int timePart is the hour or minute we will format
     */
    public String zeroTime(int timePart) {
        String timeString =  Integer.toString(timePart);
        
        if(timePart >= 0 && timePart <= 9) {
            timeString += "0" + timePart;
        }
        
        return timeString;
    }

    @Override
    public String toString() {
        return new String(zeroTime(hour) + ":" + zeroTime(minute));
    }

}
