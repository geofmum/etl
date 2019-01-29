package edu.mum.base.job;

import edu.mum.base.Record;
import edu.mum.base.log.ALogger;
import edu.mum.base.log.LoggerBuilder;
import edu.mum.base.read.DataReader;
import edu.mum.base.transform.TransformComponent;
import edu.mum.base.write.DataWriter;

import java.util.List;

public abstract class AbstractJob {
    protected DataReader reader;
    protected DataWriter writer;
    protected TransformComponent transformer;
    protected ALogger logger;

    public AbstractJob(DataReader reader, DataWriter writer, TransformComponent transformer) {
        this.reader = reader;
        this.writer = writer;
        this.transformer = transformer;
        this.logger = (new LoggerBuilder()).getLogger();
    }

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

    public List<Record> read() {
        reader.open();
        List<Record> records = reader.read();
        reader.close();
        return records;
    }

    public void afterRead() {
    }

    public void beforeWrite() {
    }

    public void write(List<Record> records) {
        writer.open();
        writer.write(records);
        writer.close();
    }

    public void afterWrite() {
    }

    public void beforeTransform() {
    }

    public List<Record> transform(List<Record> records) {
        return transformer.transform(records);
    }

    public void afterTransform() {
    }

    public final void run() {
        beforeRead();
        logger.info("Started reading data...");
        List<Record> records = read();
        logger.info("Read " + records.size() + " records");
        afterRead();

        beforeTransform();
        logger.info("Started transforming data...");
        records = transform(records);
        logger.info("Transforming is done");
        afterTransform();

        beforeWrite();
        logger.info("Started writing data to destination...");
        write(records);
        logger.info("Writing is done");
        afterWrite();
        logger.info("Everything is done");
    }
}
