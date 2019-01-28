package edu.mum.base.write.adapters;

import edu.mum.base.Record;
import edu.mum.base.field.IField;
import edu.mum.base.write.WriterAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONWriteAdapter implements WriterAdapter {
    private String filePath;
    private FileWriter writer;

    public JSONWriteAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void open() {
        try {
            writer = new FileWriter(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Record record) {
        StringBuilder output = new StringBuilder();
        output.append("{");

        record.getFields().forEach(field -> {
            // determine whether we should add a separator "," i.e if last character is not equal to "}"
            if (output.lastIndexOf("}") != output.length() - 1) {
                output.append(",");
            }
            output.append(quoteEntity(field.getName()))
                    .append(quoteEntity(field.getValue()));
        });

        output.append("}");

        try {
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(List<Record> records) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        records.forEach(record -> {
            // determine whether we should add a separator "," i.e if last character is not equal to "["
            if (output.lastIndexOf("[") != output.length() - 1) {
                output.append(",");
            }

            output.append("{");

            List<IField> fields = record.getFields();
            for (int j = 0; j < fields.size(); j++) {
                if (j > 0)
                    output.append(",");

                IField field = fields.get(j);
                output.append(quoteEntity(field.getName()))
                        .append(":")
                        .append(quoteEntity(field.getValue()));
            }

            output.append("}");
        });
        output.append("]");

        try {
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String quoteEntity(Object entity) {
        return new StringBuilder()
                .append("\"")
                .append(entity)
                .append("\"").toString();
    }
}
