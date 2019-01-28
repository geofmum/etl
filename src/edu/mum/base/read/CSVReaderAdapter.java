package edu.mum.base.read;

import edu.mum.base.field.FieldFactory;
import edu.mum.base.field.IField;
import edu.mum.base.Record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderAdapter implements ReaderAdapter{
    private String filePath;
    private String separator;
    private BufferedReader bufferedReader;

    public CSVReaderAdapter(String filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    @Override
    public void open() {
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Record read() {
        return null;
    }

    @Override
    public List<Record> readList() {
        List<Record> readRecords = new ArrayList<>();
        try {
            String regex = "\\s*" + separator + "\\s*";
            String[] header = bufferedReader.readLine().split(regex); // Reading header
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                String[] values = line.split(regex);
                List<IField> fields = new ArrayList<>();
                for(int i=0; i<header.length; i++) {
                    IField field = FieldFactory.getInsance().createField(header[i], values[i]);
                    fields.add(field);
                }
                readRecords.add(new Record(fields));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return readRecords;
    }

}
