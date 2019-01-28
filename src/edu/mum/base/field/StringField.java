package edu.mum.base.field;

public class StringField implements IField{
    private String value;
    private String name;

    public StringField(String value, String name) {
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
}
