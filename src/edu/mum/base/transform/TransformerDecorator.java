package edu.mum.base.transform;

import edu.mum.base.Record;

import java.util.List;

public class TransformerDecorator implements TransformComponent{
    protected TransformComponent transformer;

    public TransformerDecorator(TransformComponent transformer){
        this.transformer = transformer;
    }

    @Override
    public List<Record> transform(List<Record> records) {
        return transformer.transform(records);
    }
}
