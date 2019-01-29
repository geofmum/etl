package edu.mum.base.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public Date parse(DateFormat dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.toString());

        Date date = null;

        try {
            date = sdf.parse(dateFormat.getValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
