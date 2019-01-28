package edu.mum.utils;

public interface Observable {
    public void subscribe(String event, Observer observer);
    public void notifyObservers(String event, Object data);
    public void emit(String event, Object data);
}
