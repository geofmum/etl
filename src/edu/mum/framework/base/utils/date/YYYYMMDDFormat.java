package edu.mum.framework.base.utils.date;

public class YYYYMMDDFormat extends DateFormat {
    protected String format = "YYYY-MM-dd";

    public YYYYMMDDFormat(String date) {
        super(date);
    }

    @Override
    public String toString() {
        return format;
    }
}
