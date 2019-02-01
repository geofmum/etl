package edu.mum.framework.base.field;

import java.text.SimpleDateFormat;

public class DateField implements IField {
    private SimpleDateFormat value;
    private String name;

    public DateField(SimpleDateFormat value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setValue(Object value) {
        this.value = (SimpleDateFormat) value;
    }
}
