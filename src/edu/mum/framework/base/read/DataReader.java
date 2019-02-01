package edu.mum.framework.base.read;

import edu.mum.framework.base.Record;

import java.util.List;

public class DataReader {
    private ReaderAdapter adapter;

    public DataReader(){}

    public DataReader(ReaderAdapter adapter) {
        this.adapter = adapter;
    }

    public void setReadAdapter(ReaderAdapter adapter){
        this.adapter = adapter;
    }

    public void open() {
        adapter.open();
    }

    public void close() {
        adapter.close();
    }

    public List<Record> read() {
        return adapter.read();
    }
}
