package bank;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PeriodID {

    // Attributes
    int year;
    int month;
    String periodID;
    int currentYear;
    int currentMonth;
    int currentDay;
    String currentPeriod;

    // Constructor


    public PeriodID() {
        // Sets context
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        currentYear     = localDate.getYear();
        currentMonth    = localDate.getMonthValue();
        currentDay      = localDate.getDayOfMonth();
        currentPeriod   = buildPeriod(currentYear, currentMonth);

    }

    // Getters
    public int      getYear()    {   return year;     }
    public int      getMonth()   {   return month;    }
    public String   getPeriodID(){   return periodID; }


    // Setters
    public void setPeriod(int requestedYear, int requestedMonth) {

        String errors = "";

        // Year cannot be too small
        if (  (currentYear-1)> requestedYear  ) {
            errors = "Year cannot be smaller than " + currentYear + '\n';
        }

        // Year cannot be too big
        if (  (currentYear + 1) < requestedYear  ) {
            errors = "Year cannot be bigger than " + (currentYear + 1) + '\n';
        }

        // Month has to be a value between 1 and 12
        if ( (month < 1) || (month > 12)   ) {
            errors = "Month cannot be smaller than 1 or bigger than 12";
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors);
        }

        this.year = requestedYear;
        this.month = requestedMonth;

        periodID = buildPeriod(year, month);
    }

    public String buildPeriod(int year, int month) {
        String zero = "";
        if (month < 10) { zero = "0"; }
        return String.valueOf(year) + zero + String.valueOf(month);
    }

}
