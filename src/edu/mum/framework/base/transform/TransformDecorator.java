package edu.mum.framework.base.transform;

import edu.mum.framework.base.Record;

import java.util.List;

public class TransformDecorator implements TransformComponent{
    protected TransformComponent transformer;

    public TransformDecorator(TransformComponent transformer){
        this.transformer = transformer;
    }

    @Override
    public List<Record> transform(List<Record> records) {
        return transformer.transform(records);
    }
}
