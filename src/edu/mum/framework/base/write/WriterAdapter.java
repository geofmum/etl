package edu.mum.framework.base.write;

import edu.mum.framework.base.Record;

import java.util.List;

public interface WriterAdapter {
    public void open();

    public void close();

    public void write(Record rec);

    public void write(List<Record> records);
}
