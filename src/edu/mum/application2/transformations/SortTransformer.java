package edu.mum.application2.transformations;

import edu.mum.framework.base.Record;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.transform.TransformDecorator;

import java.util.Comparator;
import java.util.List;

public class SortTransformer extends TransformDecorator {
    private String sortField;
    private SortOrder sortOrder;

    private enum SortOrder {
        ASC, DESC
    }

    private class RecordComparator implements Comparator<Record> {

        @Override
        public int compare(Record r1, Record r2) {
            String v1 = r1.getField(sortField).getValue().toString();
            String v2 = r2.getField(sortField).getValue().toString();

            switch (sortOrder) {
                case DESC:
                    return v2.compareTo(v1);
                default:
                    return v1.compareTo(v2);
            }
        }
    }

    public SortTransformer(TransformComponent transformer) {
        super(transformer);
    }

    @Override
    public List<Record> transform(List<Record> records) {
        records = sort(records);

        return super.transform(records);
    }

    public SortTransformer sortAscendingBy(String sortField) {
        this.sortField = sortField;
        sortOrder = SortOrder.ASC;
        return this;
    }

    public SortTransformer sortDescendingBy(String sortField) {
        this.sortField = sortField;
        sortOrder = SortOrder.DESC;
        return this;
    }

    private List<Record> sort(List<Record> records) {
        Comparator<Record> comparator = new RecordComparator();
        records.sort(comparator);

        return records;
    }
}
