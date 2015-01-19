package org.arguman.app.util;

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

    public static String getTimeAgo() {
        long time = timestamp.getTime();
        long now = CURRENT_TIME.getTime();
        if (time > now || time <= 0)
            return "";
        int dim = getTimeDistanceInMinutes(time);
        if (dim == 0)
            return context.getString(R.string.timestamp_just_now);
        else if (dim >= 2 && dim <= 44)
            return dim + " " + context.getString(R.string.timestamp_minutes_ago);
        else if (dim >= 45 && dim <= 89)
            return context.getString(R.string.timestamp_an_hour_ago);
        else if (dim >= 90 && dim <= 1439)
            return (Math.round(dim / 60)) + " " + context.getString(R.string.timestamp_hours_ago);
        else if (dim >= 1440 && dim <= 2519)
            return context.getString(R.string.timestamp_yesterday);
        else if (dim >= 2520 && dim <= 43199)
            return (Math.round(dim / 1440)) + " " + context.getString(R.string.timestamp_days_ago);
        else if (dim >= 43200 && dim <= 86399)
            return context.getString(R.string.timestamp_last_month);
        else if (dim >= 86400 && dim <= 525599)
            return (Math.round(dim / 43200)) + " " + context.getString(R.string.timestamp_months_ago);
        else if (dim >= 525600 && dim <= 655199)
            return context.getString(R.string.timestamp_last_year);
        return (Math.round(dim / 525600)) + " " + context.getString(R.string.timestamp_years_ago);
    }

    private static int getTimeDistanceInMinutes(long time) {
        long timeDistance = CURRENT_TIME.getTime() - time;
        return Math.round((Math.abs(timeDistance) / 1000) / 60);
    }

}
