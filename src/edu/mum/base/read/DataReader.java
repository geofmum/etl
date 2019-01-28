package edu.mum.base.read;

import edu.mum.base.Record;

import java.util.List;

public class DataReader {
    private ReaderAdapter reader;

    public DataReader(ReaderAdapter reader) {
        this.reader = reader;
    }

    public void open(){
        reader.open();
    }

    public void close(){
        reader.close();
    }

    public Record read(){
        return reader.read();
    }

    public List<Record> readList(){
        return reader.readList();
    }
}
