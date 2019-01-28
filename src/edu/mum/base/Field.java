package edu.mum.base;

public class Field {
    private FieldType type;
    private Object value;
    private String name;

    public Field(FieldType type, Object value, String name) {
        this.type = type;
        this.value = value;
        this.name = name;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
