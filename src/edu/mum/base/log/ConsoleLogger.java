package edu.mum.base.log;

import edu.mum.Settings;

public class ConsoleLogger extends ALogger {
    @Override
    public void error(String message) {
        if(canHandleRequest()) {
            log("ERROR: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public void info(String message) {
        if(canHandleRequest()) {
            log("INFO: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public void debug(String message) {
        if(canHandleRequest()) {
            log("DEBUG: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public boolean canHandleRequest() {
        return Settings.ENV == "development";
    }

    private void log(String message) {
        System.out.println(message);
    }
}
