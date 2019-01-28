package edu.mum.io;

import edu.mum.base.DataSource;

import java.io.*;

public class CSVFileSource implements DataSource {
    private String filename;
    private FileReader reader;

    public CSVFileSource(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() {
        if (!isInitialized())
            initialize();

        BufferedReader bf = new BufferedReader(reader);
        StringBuilder output = new StringBuilder();
        String line;

        try {
            while ((line = bf.readLine()) != null) {
                output.append(line)
                        .append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    @Override
    public String stream() {
        return null;
    }

    @Override
    public void initialize() {
        try {
            reader = new FileReader(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean isInitialized() {
        return reader != null;
    }
}
