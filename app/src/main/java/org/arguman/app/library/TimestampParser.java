package org.arguman.app.library;

import android.content.Context;

import org.arguman.app.R;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampParser {

    private static Context context;
    private static TimestampParser timestampParser;
    private static final String LOG_TAG = "TimestampParser";
    private static final Timestamp CURRENT_TIME = new Timestamp(new Date().getTime());
    private static Timestamp timestamp;

    private TimestampParser(Context context) {
        this.context = context;
    }

    public static TimestampParser getInstance(Context context) {
        if (timestampParser == null)
            timestampParser = new TimestampParser(context);
        return timestampParser;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getCurrentTimestamp() {
        return CURRENT_TIME;
    }

    private long getTimeDifference() {
        return Math.abs(CURRENT_TIME.getTime() - timestamp.getTime());
    }

    public long getSecondDifference() {
        return getTimeDifference() / 1000;
    }

    public long getMinuteDifference() {
        return getTimeDifference() / (60 * 1000);
    }

    public long getHourDifference() {
        return getTimeDifference() / (60 * 60 * 1000);
    }

    public long getDayDifference() {
        return getTimeDifference() / (24 * 60 * 60 * 1000);
    }

    public long getWeekDifference() {
        return getTimeDifference() / (7 * 24 * 60 * 60 * 1000);
    }

    public long getMonthDifference() {
        return getTimeDifference() / (30 * 24 * 60 * 60 * 1000);
    }

    public long getYearDifference() {
        return getTimeDifference() / (365 * 24 * 60 * 60 * 1000);
    }

    public long getDifference() {
        if (getMonthDifference() >= 12)
            return getYearDifference();
        if (getWeekDifference() >= 4)
            return getMonthDifference();
        if (getDayDifference() >= 7)
            return getWeekDifference();
        if (getHourDifference() >= 24)
            return getDayDifference();
        if (getMinuteDifference() >= 60)
            return getHourDifference();
        if (getSecondDifference() >= 60)
            return getMinuteDifference();
        return getSecondDifference();
    }

    public String getDifferenceExtension() {
        if (getMonthDifference() == 12)
            return context.getString(R.string.timestamp_year);
        if (getMonthDifference() > 12)
            return context.getString(R.string.timestamp_years);
        if (getWeekDifference() == 4)
            return context.getString(R.string.timestamp_month);
        if (getWeekDifference() > 4)
            return context.getString(R.string.timestamp_months);
        if (getDayDifference() == 7)
            return context.getString(R.string.timestamp_week);
        if (getDayDifference() > 7)
            return context.getString(R.string.timestamp_weeks);
        if (getHourDifference() == 24)
            return context.getString(R.string.timestamp_day);
        if (getHourDifference() > 24)
            return context.getString(R.string.timestamp_days);
        if (getMinuteDifference() == 60)
            return context.getString(R.string.timestamp_hour);
        if (getMinuteDifference() > 60)
            return context.getString(R.string.timestamp_hours);
        if (getSecondDifference() == 60)
            return context.getString(R.string.timestamp_minute);
        if (getSecondDifference() > 60)
            return context.getString(R.string.timestamp_minutes);
        if (getSecondDifference() == 1)
            return context.getString(R.string.timestamp_second);
        return context.getString(R.string.timestamp_seconds);
    }

}
