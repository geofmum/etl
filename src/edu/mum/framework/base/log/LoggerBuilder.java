package edu.mum.framework.base.log;

public class LoggerBuilder {
    private ALogger logger;

    public LoggerBuilder() {
        BuildChain();
    }
    public ALogger getLogger() {
        return logger;
    }

    private void BuildChain() {
        ALogger consoleLogger = new ConsoleLogger();
        ALogger fileLogger = new FileLogger();
        consoleLogger.setNextLogger(fileLogger);
        this.logger = consoleLogger;
    }
}
