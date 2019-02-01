package edu.mum.framework.base.utils.date;

public class DateFormatFactory {
    private static String MMDDYYYYmatcher = ".*\\d{1,2}[/\\.-]+\\d{1,2}[/\\.-]+\\d{4}.*";
    private static String YYYYMMDDmatcher = ".*\\d{4}[/\\.-]+\\d{1,2}[/\\.-]+\\d{1,2}.*";

    public static DateFormat create(String date){
        date = date.trim();
        if (date.matches(MMDDYYYYmatcher)){
            return new MMDDYYYYFormat(date);
        } else if (date.matches(YYYYMMDDmatcher)){
            return new YYYYMMDDFormat(date);
        }

        return null;
    }
}
