package edu.mum.framework.base.transform.computedfield;

import edu.mum.framework.base.Record;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.transform.TransformDecorator;

import java.util.List;

public class ComputedFieldDecorator extends TransformDecorator {
    private ComputingStrategy computingStrategy;
    public ComputedFieldDecorator(TransformComponent transformer) {
        super(transformer);
    }

    public void setComputingStrategy(ComputingStrategy computingStrategy) {
        this.computingStrategy = computingStrategy;
    }

    @Override
    public List<Record> transform(List<Record> records) {
        records = computingStrategy.apply(records);
        return super.transform(records);
    }

    public ComputedFieldDecorator addComputedField(String fieldName, List<String> sourceFields) {
        ComputingStrategy concatFieldsStrategy = new ConcatFieldsStrategy();
        concatFieldsStrategy.setFieldName(fieldName);
        concatFieldsStrategy.setSourceFields(sourceFields);
        this.computingStrategy = concatFieldsStrategy;

        return this;
    }
    public ComputedFieldDecorator addComputedField(String fieldName, List<String> sourceFields, ComputingStrategy computingStrategy) {
        computingStrategy.setFieldName(fieldName);
        computingStrategy.setSourceFields(sourceFields);
        this.computingStrategy = computingStrategy;

        return this;
    }
}
