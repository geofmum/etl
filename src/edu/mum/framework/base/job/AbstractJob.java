package edu.mum.framework.base.job;

import edu.mum.framework.base.Record;
import edu.mum.framework.base.read.DataReader;
import edu.mum.framework.base.transform.TransformComponent;
import edu.mum.framework.base.write.DataWriter;

public abstract class AbstractJob {
    protected DataReader reader;
    protected DataWriter writer;
    protected TransformComponent transformer;

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

        beforeWrite();
        write();
        afterWrite();

        beforeTransform();
        transform();
        afterTransform();
    }
}
