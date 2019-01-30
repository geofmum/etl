package edu.mum.base.write.adapters;

import edu.mum.base.Record;
import edu.mum.base.log.ALogger;
import edu.mum.base.log.LoggerBuilder;
import edu.mum.base.write.WriterAdapter;

import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class CSVWriterAdapter implements WriterAdapter {

    private String filePath;
    private FileWriter writer;
    private String separater;
    private ALogger logger;


    public CSVWriterAdapter(String filePath, String separater){
        this.filePath=filePath;
        this.separater=separater;
        logger=new LoggerBuilder().getLogger();
    }

    @Override
    public void open() {
        try {
            writer = new FileWriter(filePath);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            writer.flush();
            writer.close();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void write(Record rec) {

    }

    @Override
    public void write(List<Record> records) {
        try {
            String header = records.get(0).getFields().stream().map(e -> e.getName()).collect(Collectors.joining(separater));
            writer.write(header+"\n");
            for(Record record: records){
                String output=record.getFields().stream().map(e -> e.getValue().toString()).collect(Collectors.joining(separater));
                writer.write(output+"\n");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
