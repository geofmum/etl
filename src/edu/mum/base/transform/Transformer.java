package edu.mum.base.transform;

import edu.mum.base.Record;

import java.util.List;

public class Transformer implements TransformComponent {
    public Transformer() {
    }

    @Override
    public List<Record> transform(List<Record> records) {
        return records;
    }
}
