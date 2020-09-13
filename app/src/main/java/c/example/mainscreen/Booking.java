package c.example.mainscreen;

public class Booking {
    private  String Calendar;
    private  String Date;
    private String Time;

    public String getCalendar(){return Calendar; }

    public void setCalendar(String calendar){
        Calendar = calendar;
    }

    public String getDate(){return Date;}

    public void setDate(String date) {
        Date = date;
    }

    public String getTime(){return Time;}

    public void setTime(String time) {
        Time = time;
    }
}
