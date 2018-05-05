/**
 * This class represents a Date object
 * @author RoyHadad
 * @version 2018
 */

public class Date
{
    //constants
    private static final int MIN_DAY = 1;
    private static final int MAX_DAYS_LONG_MONTH = 31;
    private static final int MAX_DAYS_REGULAR_MONTH = 30;
    private static final int MAX_DAYS_LEAP_FEB = 29;
    private static final int MAX_DAYS_REGULAR_FEB = 28;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_YEAR = 1000;
    private static final int MAX_YEAR = 9999;
    private static final int DEFUALT_DAY = 1;
    private static final int DEFUALT_MONTH = 1;
    private static final int DEFUALT_YEAR = 2000;
    private static final int JANUARY_MONTH_NUM = 1;
    private static final int FEBRUARY_MONTH_NUM = 2;
    private static final int MARCH_MONTH_NUM = 3;
    private static final int APRIL_MONTH_NUM = 4;
    private static final int MAY_MONTH_NUM = 5;
    private static final int JUNE_MONTH_NUM = 6;
    private static final int JULY_MONTH_NUM = 7;
    private static final int AUGUST_MONTH_NUM = 8;
    private static final int SEPTEMBER_MONTH_NUM = 9;
    private static final int OCTOBER_MONTH_NUM = 10;
    private static final int NOVEMBER_MONTH_NUM = 11;
    private static final int DECEMBER_MONTH_NUM = 12;
    
    //the object's parameters
    private int _day;
    private int _month;
    private int _year;
    
    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */
    public Date(int day, int month, int year)
    {
        if(isDateProper(day, month, year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else
        {
            _day = DEFUALT_DAY;
            _month = DEFUALT_MONTH;
            _year = DEFUALT_YEAR;
        }
    }
    
    /**
     * copy constructor
     * @param other the date to be copied
     */
    public Date(Date other)
    {
        if(other!=null)
        {
            _day = other._day;
            _month = other._month;
            _year = other._year;
        }
        else
        {
            _day = DEFUALT_DAY;
            _month = DEFUALT_MONTH;
            _year = DEFUALT_YEAR;
        }
    }
    
    /**
     * gets the Day
     * @return the day
     */
    public int getDay()
    {
        return _day;
    }
    
    /**
     * gets the month
     * @return the month
     */
    public int getMonth()
    {
        return _month;
    }
    
    /**
     * gets the year
     * @return the year
     */
    public int getYear()
    {
        return _year;
    }
    
    /**
     * sets the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
        if(isDateProper(dayToSet, _month, _year))
            _day = dayToSet;
    }
    
    /**
     * set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet)
    {
        if(isDateProper(_day, monthToSet, _year))
            _month = monthToSet;
    }
    
    /**
     * sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if(isDateProper(_day, _month, yearToSet))
            _year = yearToSet;
    }
    
    /**
     * check if 2 dates are the same
     */
    public boolean equals(Date other)
    {
        if(_day==other._day && _month==other._month && _year==other._year)
            return true;
        else
            return false;
    }
    
    /**
     * check if this date is before other date
     * @return true if this date is before other date
     */
    public boolean before(Date other)
    {
        if(_year<other._year)
            return true;
        else if(_year>other._year)
            return false;
        else
        {
            if(_month<other._month)
                return true;
            else if(_month>other._month)
                return false;
            else
            {
                if(_day<other._day)
                    return true;
                else
                    return false;
            }
        }
    }
    
    /**
     * check if this date is after other date
     * @return true if this date is after other date
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }
    
    /**
     * calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates
     */
    public int difference(Date other)
    {
        return Math.abs(calculateDate(_day, _month, _year)-calculateDate(other._day, other._month, other._year));
    }
    
    /**
     * returns a String that represents this date
     * @Override toString in class java.lang.Object
     * @return String that represents this date in the following format: day/month/year for example: 2/3/1998
     */
    public String toString()
    {
        return _day+"/"+_month+"/"+_year;
    }
    
    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * return the day of the week that this date occurs on
     */
    public int dayInWeek()
    {
        int day = _day;
        int month = _month;
        int year = _year;
        int decades = 0;
        int centuries = 0;
        if(month<3)
        {
            year--;
            month=month+12;
        }
        decades = year%100;
        centuries = year/100;
        return Math.floorMod(day+(26*(month+1))/10 + decades + decades/4 + centuries/4 - 2*centuries, 7);
    }
    
    //calculates the days that have passed since the start of the gregorian calendar
    private static int calculateDate(int day, int month, int year)
    {
        if(month<3)
        {
            year--;
            month=month+12;
        }
        return 365*year + year/4 - year/100 + year/400 + ((month+1)*306)/10 + (day-62);
    }
    
    //check whether or not the year is a leap year.
    //if it is a leap year, returns true, otherwise returns false
    private static boolean leap(int y)
    {
        return(y%4==0&&y%100!=0)||(y%400==0);
    }
    
    //checks whether or not the the date (day, month, year) is legal or not. 
    //if legal, returns true, otherwise returns false
    private static boolean isDateProper(int day, int month, int year)
    {
        if(year<MIN_YEAR||year>MAX_YEAR)
            return false;
        switch (month)
        {
             case JANUARY_MONTH_NUM:
             case MARCH_MONTH_NUM:
             case MAY_MONTH_NUM:
             case JULY_MONTH_NUM:
             case AUGUST_MONTH_NUM:
             case OCTOBER_MONTH_NUM:
             case DECEMBER_MONTH_NUM:
                if(day<MIN_DAY||day>MAX_DAYS_LONG_MONTH)
                    return false;
                break;
             case APRIL_MONTH_NUM:
             case JUNE_MONTH_NUM:
             case SEPTEMBER_MONTH_NUM:
             case NOVEMBER_MONTH_NUM:
                if(day<MIN_DAY||day>MAX_DAYS_REGULAR_MONTH)
                    return false;
                break;
             case FEBRUARY_MONTH_NUM:
                if(leap(year))
                {
                    if(day<MIN_DAY||day>MAX_DAYS_LEAP_FEB)
                        return false;
                }
                else
                {
                    if(day<MIN_DAY||day>MAX_DAYS_REGULAR_FEB)
                        return false;
                }
                break;
             default:
                return false;
        }
        return true;
    }
}