package edu.mum.base.transform.computedfield;

import edu.mum.base.Field;
import edu.mum.base.Record;
import edu.mum.base.field.FieldFactory;
import edu.mum.base.field.IField;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConcatFieldsStrategy implements ComputingStrategy {
    private String fieldName;
    private List<String> sourceFields;

    @Override
    public List<Record> apply(List<Record> list) {
        List<Record> transformedList= list.stream().map(r -> {
            String value = _concatValues(r);
            IField field = FieldFactory.getInsance().createField(fieldName, value);
            r.addField(field);
            return r;
        }).collect(Collectors.toList());

        return transformedList;
    }

    @Override
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public void setSourceFields(List<String> sourceFields) {
        this.sourceFields = sourceFields;
    }

    private String _concatValues(Record record) {
        return record
                .getFields()
                .stream()
                .filter(f -> sourceFields.contains(f.getName()))
                .map(f->f.getValue().toString())
                .collect(Collectors.joining(" "));
    }
}
