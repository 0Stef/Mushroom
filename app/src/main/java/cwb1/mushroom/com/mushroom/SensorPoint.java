package cwb1.mushroom.com.mushroom;

import java.sql.Timestamp;
import java.util.Calendar;

public abstract class SensorPoint {

    private int _id;
    private long millisec;

    public SensorPoint() {
        Calendar calendar = Calendar.getInstance();
        this.millisec = calendar.getTimeInMillis();
    }

    public SensorPoint(long millisec) {
        this.millisec = millisec;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public void setMillis(long millisec) {
        this.millisec = millisec;
    }

    public long getMillisec() {
        return millisec;
    }

    public Calendar getCalendar() {
        Timestamp stamp = new Timestamp(getMillisec());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stamp);
        return calendar;
    }

    public int getYear() {
        Calendar calendar = getCalendar();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public int getMonth() {
        Calendar calendar = getCalendar();
        int month = calendar.get(Calendar.MONTH);
        return month;
    }

    public int getWeek() {
        Calendar calendar = getCalendar();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week;
    }

    public int getDay() {
        Calendar calendar = getCalendar();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;
    }

    public int getHour() {
        Calendar calendar = getCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public int getMinute() {
        Calendar calendar = getCalendar();
        int minute = calendar.get(Calendar.MINUTE);
        return minute;
    }

    public int getSecond() {
        Calendar calendar = getCalendar();
        int second = calendar.get(Calendar.SECOND);
        return second;
    }
}
