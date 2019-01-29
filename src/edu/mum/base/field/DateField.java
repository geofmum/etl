package edu.mum.base.field;

import edu.mum.base.utils.date.DateFormat;
import edu.mum.base.utils.date.DateFormatFactory;
import edu.mum.base.utils.date.DateParser;

import java.util.Date;

public class DateField implements IField {
    private Date value;
    private String name;

    public DateField(Date value, String name) {
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
        DateFormat dateFormat = DateFormatFactory.create(value.toString());
        dateFormat.parser(new DateParser());

        this.value = dateFormat.getParsedDate();
    }
}
