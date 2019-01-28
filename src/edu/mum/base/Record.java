package edu.mum.base;

import edu.mum.base.field.IField;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<IField> fields = new ArrayList<>();

    public Record(List<IField> fields) {
        this.fields = fields;
    }

    public List<IField> getFields() {
        return fields;
    }

    public IField getField(String name) {
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
