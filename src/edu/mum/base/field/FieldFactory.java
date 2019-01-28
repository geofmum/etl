package edu.mum.base.field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldFactory {
    private static FieldFactory INSTANCE;
    private FieldFactory() {

    }

    public synchronized static FieldFactory getInsance() {
        if(INSTANCE == null) {
            INSTANCE = new FieldFactory();
        }
        return INSTANCE;
    }

    public IField createField(String name, String value) {
        IField field = null;

        if(isInteger(value)) {
            field = new IntegerField(Integer.parseInt(value), name);
        } else if(isDate(value)) {
            field = new DateField(new Date(value), name);
        } else {
            field = new StringField(value, name);
        }

        return field;
    }

    private static boolean isInteger(String value) {
        try {
            int intValue = Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }


    public static boolean isDate(String value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(value.trim());
        } catch (Exception pe) {
            return false;
        }
        return true;
    }
}
