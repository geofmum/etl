package edu.mum.base.field;

public class IntegerField implements IField {
    private Integer value;
    private String name;

    public IntegerField(Integer value, String name) {
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
