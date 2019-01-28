package edu.mum.framework.base;

public class Pipeline {
    public static Pipeline instance;

    private Pipeline() {}

    public static Pipeline getInstance(){
        synchronized (Pipeline.class) {
            if(instance == null){
                instance = new Pipeline();
            }
        }

        return instance;
    }

    public void onRead(){}
    public void onWrite(){}
    public void onTransform(){}

    public final void run(){}
}
