package edu.mum.base;

public class Extractor {
    // the channel the task is associated with
    private String channel;
    private String data;
    public DataSource source;

    public Extractor(DataSource source) {
        this.source = source;
    }

    public Extractor(String channel, DataSource source) {
        this.channel = channel;
        this.source = source;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void extract() {
        String data = source.read();
        setData(data);
    }

    private void setData(String data) {
        this.data = data;

        Pipeline.getInstance().emit(channel, data);
    }
}
