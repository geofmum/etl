package edu.mum.framework.base.transform;

import edu.mum.framework.base.Record;

import java.util.List;

public class Transformer implements TransformComponent {
    public Transformer() {
    }

    @Override
    public List<Record> transform(List<Record> records) {
        return records;
    }
}
