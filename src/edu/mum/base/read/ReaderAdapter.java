package edu.mum.base.read;

import edu.mum.base.Record;

import java.util.List;

public interface ReaderAdapter {
    public void open();
    public void close();
    public Record read();
    public List<Record> readList();
}
