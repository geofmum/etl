package edu.mum.framework.base;

public class Field {
    private Object value;
    private String name;

    public Field(Object value, String name) {
        this.value = value;
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
