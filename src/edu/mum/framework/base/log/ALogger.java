package edu.mum.framework.base.log;

public abstract class ALogger {
    private ALogger nextLogger;
    public abstract void error(String message);
    public abstract void info(String message);
    public abstract void debug(String message);
    public abstract boolean canHandleRequest();
    public ALogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(ALogger nextLogger) {
        this.nextLogger = nextLogger;
    }
}
