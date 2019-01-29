package edu.mum.base.read.csv;

import edu.mum.base.field.FieldFactory;
import edu.mum.base.field.IField;
import edu.mum.base.Record;
import edu.mum.base.read.ReaderAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderAdapter implements ReaderAdapter {
    private String filePath;
    private String separator;
    private boolean allowEmpty;
    private String charset = "UTF";
    private List<String> dateFormats = new ArrayList<>();

    private BufferedReader bufferedReader;

    public CSVReaderAdapter() {
    }

    public CSVReaderAdapter(String filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    public void setAllowEmpty (boolean allowEmpty){
        this.allowEmpty = allowEmpty;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void addDateFormat (String dateFormat){
        this.dateFormats.add(dateFormat);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
    public List<Record> read() {
        List<Record> readRecords = new ArrayList<>();
        try {
            String regex = "\\s*" + separator + "\\s*";
            String[] header = bufferedReader.readLine().split(regex); // Reading header
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty() && !allowEmpty)
                    continue;

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
