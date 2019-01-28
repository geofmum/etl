package edu.mum.base.write;

import edu.mum.base.Record;

import java.util.List;

public class DataWriter {
    public WriterAdapter writer;

    public DataWriter(WriterAdapter writer) {
        this.writer = writer;
    }

    public void open() {
        writer.open();
    }

    public void close() {
        writer.close();
    }

    public void write(Record record) {
        writer.write(record);
    }

    public void write(List<Record> records) {
        writer.write(records);
    }
}
