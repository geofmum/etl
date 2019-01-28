package edu.mum.framework.base;

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
}
