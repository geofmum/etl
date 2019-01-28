package edu.mum.base;

public interface DataSource {
    public <T> T read();
    public <T> T stream();
    public void initialize();
}
