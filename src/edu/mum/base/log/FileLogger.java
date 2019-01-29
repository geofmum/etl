package edu.mum.base.log;
import edu.mum.Settings;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger extends ALogger {
    @Override
    public void error(String message) {
        if(canHandleRequest()) {
            writeToFile("ERROR: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public void info(String message) {
        if(canHandleRequest()) {
            writeToFile("INFO: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public void debug(String message) {
        if(canHandleRequest()) {
            writeToFile("DEBUG: "+ message);
        } else if(this.getNextLogger() != null) {
            this.getNextLogger().error(message);
        }
    }

    @Override
    public boolean canHandleRequest() {
        return Settings.ENV == "production";
    }

    private void writeToFile(String str) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            writer.append(str + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
    }
}

