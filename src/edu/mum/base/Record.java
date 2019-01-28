package edu.mum.base;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<Field> fields = new ArrayList<>();

    public Record(List<Field> fields) {
        this.fields = fields;
    }

    public List<Field> getFields() {
        return fields;
    }

    public Field getField(String name) {
        return fields.stream()
            .filter(field -> name.equals(field.getName()))
            .findFirst()
            .orElse(null);
    }

    public boolean hasField(String name){
        return fields.stream()
                .anyMatch(field -> name.equals(field.getName()));
    }
}
