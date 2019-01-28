package edu.mum.base.transform.computedfield;

import edu.mum.base.Record;

import java.util.List;

public interface ComputingStrategy {
    public List<Record> apply(List<Record> list);
    public void setFieldName(String fieldName);
    public void setSourceFields(List<String> sourceFields);
}
