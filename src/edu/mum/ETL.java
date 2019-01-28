package edu.mum;

import edu.mum.base.*;
import edu.mum.io.CSVFileSource;
import edu.mum.io.JSONFileOutput;
import edu.mum.transform.CSVParser;

public class ETL {
    public static void main(String[] args){
        DataSource ds = new CSVFileSource("./test.csv");
        Pipeline pipeline = Pipeline.getInstance();
        pipeline.registerExtractor(new Extractor("extract.csv.local", ds));

        Transformer transformer = new Transformer("transform.csv.local");
        transformer.registerParser(new CSVParser());
        transformer.subscribe("extract.csv.local", pipeline);

        Loader loader = new Loader("load.csv.local", new JSONFileOutput());
        loader.subscribe("transform.csv.local", pipeline);

        pipeline.start();
    }
}
