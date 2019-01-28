package edu.mum.base.transform;

import edu.mum.base.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenameFieldDecorator extends TransformDecorator {
    private Map<String, String> fieldMap = new HashMap<String, String>();

    public RenameFieldDecorator(TransformComponent transformer) {
        super(transformer);
    }

    @Override
    public List<Record> transform(List<Record> records) {
        records = _transform(records);

        return super.transform(records);
    }

    private List<Record> _transform(List<Record> records) {
        if (records == null || records.size() == 0)
            return records;

        fieldMap.entrySet()
                .stream()
                .filter(entry -> records.get(0).hasField(entry.getKey()))
                .forEach(entry -> {
                    records.stream()
                        .forEach(record -> {
                            String oldName = entry.getKey();
                            String newName = entry.getValue();

                            record.getField(oldName).setName(newName);
                        });
                });

        return records;
    }

    public RenameFieldDecorator rename(String from, String to) {
        fieldMap.put(from, to);
        return this;
    }

    public RenameFieldDecorator renameAll(Map<String, String> fields) {
        fieldMap.putAll(fields);

        return this;
    }
}
