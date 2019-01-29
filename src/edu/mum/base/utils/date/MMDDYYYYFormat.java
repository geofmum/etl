package edu.mum.base.utils.date;

public class MMDDYYYYFormat extends DateFormat {
    protected String format = "dd-MM-yyyy";

    public MMDDYYYYFormat(String date) {
        super(date);
    }

    @Override
    public String toString() {
        return format;
    }
}
