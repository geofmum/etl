package edu.mum.base.transform;

import edu.mum.base.Record;

import java.util.List;

public interface TransformComponent {
    public List<Record> transform(List<Record> records);
}
