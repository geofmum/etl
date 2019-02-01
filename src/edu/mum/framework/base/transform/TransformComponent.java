package edu.mum.framework.base.transform;

import edu.mum.framework.base.Record;

import java.util.List;

public interface TransformComponent {
    public List<Record> transform(List<Record> records);
}
