package edu.mum.base.utils.date;

import java.util.Date;

public abstract class DateFormat {
    protected String format = "";
    protected String value;
    protected Date parsedDate;

    public DateFormat(String date) {
        value = date;
    }

    public void parser(DateParser parser){
        parsedDate = parser.parse(this);
    }

    public String getValue(){
        return value;
    }

    public Date getParsedDate(){
        return parsedDate;
    }

    @Override
    public abstract String toString();
}
