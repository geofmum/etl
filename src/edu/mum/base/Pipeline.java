package edu.mum.base;

import edu.mum.utils.Observable;
import edu.mum.utils.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pipeline implements Observable {
    private static Pipeline instance;
    private Map<String, ArrayList<Observer>> observers = new HashMap<String, ArrayList<Observer>>();
    private List<Extractor> extractors = new ArrayList<>();

    public static Pipeline getInstance(){
        synchronized (Pipeline.class){
            if(instance == null)
                instance = new Pipeline();
        }

        return instance;
    }

    public void registerExtractor(Extractor extractor){
        extractors.add(extractor);
    }

    public void start(){
        extractors.forEach(Extractor::extract);
    }

    @Override
    public void subscribe(String event, Observer observer) {
        ArrayList<Observer> eventObservers;

        if(!observers.containsKey(event))
            observers.putIfAbsent(event, new ArrayList<Observer>());

        eventObservers = observers.get(event);
        eventObservers.add(observer);
    }

    @Override
    public void notifyObservers(String event, Object data) {
        observers.getOrDefault(event, new ArrayList<Observer>()).stream()
                .forEach(observer -> observer.update(data));
    }

    @Override
    public void emit(String event, Object data) {
        notifyObservers(event, data);
    }
}
