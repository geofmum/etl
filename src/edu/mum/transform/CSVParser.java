package edu.mum.transform;

import edu.mum.base.Transformer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class CSVParser extends Transformer {
    @Override
    public void transform(String channel, Object data) {
        String[] lines = String.valueOf(data).split(".*\\n.*");

        if (lines.length == 0)
            return;

        String[] header = lines[0].split(".*,.*");
        Map<String, String> parsed = new HashMap<>();

        Stream.of(lines)
                .skip(1)
                .filter(Objects::nonNull)
                .filter(line -> line.length() > 0)
                .forEach(line -> {
                    String[] values = line.split(".*,.*");

                    for (int i = 1; i < values.length; i++) {
                        parsed.put(header[i], values[i]);
                    }
                });

        super.transform(channel, parsed);
    }
}
