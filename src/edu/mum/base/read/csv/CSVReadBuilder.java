package edu.mum.base.read.csv;

import edu.mum.base.read.DataReader;

public class CSVReadBuilder {
    private CSVReaderAdapter readAdapter;
    private DataReader reader;

    public CSVReadBuilder() {
        readAdapter = new CSVReaderAdapter();
        reader = new DataReader();
    }

    public CSVReadBuilder allowEmpty(boolean allowEmpty){
        readAdapter.setAllowEmpty(allowEmpty);
        return this;
    }

    public CSVReadBuilder separator(String separator){
        readAdapter.setSeparator(separator);
        return this;
    }

    public CSVReadBuilder charset(String charset){
        readAdapter.setCharset(charset);
        return this;
    }

    public CSVReadBuilder addDateFormat(String dateFormat){
        readAdapter.addDateFormat(dateFormat);
        return this;
    }

    public CSVReadBuilder filepath(String filepath){
        readAdapter.setFilePath(filepath);
        return this;
    }

    public DataReader build(){
        reader.setReadAdapter(readAdapter);
        return reader;
    }
}
