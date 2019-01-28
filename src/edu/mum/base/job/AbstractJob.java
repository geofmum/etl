package edu.mum.base.job;

import edu.mum.base.Record;
import edu.mum.base.read.DataReader;
import edu.mum.base.transform.TransformComponent;
import edu.mum.base.write.DataWriter;

public abstract class AbstractJob {
    protected DataReader reader;
    protected DataWriter writer;
    protected TransformComponent transformer;

    public DataReader getReader() {
        return reader;
    }

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public DataWriter getWriter() {
        return writer;
    }

    public void setWriter(DataWriter writer) {
        this.writer = writer;
    }

    public TransformComponent getTransformer() {
        return transformer;
    }

    public void setTransformer(TransformComponent transformer) {
        this.transformer = transformer;
    }

    public void beforeRead() {
    }

    public void read() {
        reader.open();
    }

    public void afterRead() {
    }

    public void beforeWrite() {
    }

    public void write(Record record) {
        writer.write(record);
    }

    public void afterWrite() {
    }

    public void beforeTransform() {
    }

    public void transform() {
        transformer.transform();
    }

    public void afterTransform() {
    }

    public final void run() {
        beforeRead();
        read();
        afterRead();

        beforeTransform();
        transform();
        afterTransform();

        beforeWrite();
        write();
        afterWrite();
    }
}
