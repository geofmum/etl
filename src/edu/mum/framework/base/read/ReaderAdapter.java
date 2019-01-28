package edu.mum.framework.base.read;

import edu.mum.framework.base.Record;

import java.util.List;

public interface ReaderAdapter {
    public void open();
    public void close();
    public Record read();
    public List<Record> readList();
}
