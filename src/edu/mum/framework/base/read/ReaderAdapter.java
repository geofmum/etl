package edu.mum.framework.base.read;

import edu.mum.framework.base.Record;

import java.util.List;

public interface ReaderAdapter {
    public void open();
    public void close();
    public List<Record> read();
}
