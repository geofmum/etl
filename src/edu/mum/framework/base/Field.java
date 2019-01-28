package edu.mum.framework.base;

public class Field {
    private FieldType type;
    private Object value;
    private String name;

    public Field(FieldType type, Object value, String name) {
        this.type = type;
        this.value = value;
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
