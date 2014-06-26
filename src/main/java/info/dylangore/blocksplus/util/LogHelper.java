package info.dylangore.blocksplus.util;

import info.dylangore.blocksplus.reference.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;


public class LogHelper {
    private static Logger bpLogger = LogManager.getLogger(Reference.ID);

    public static void init() {
    }

    public static void log(Level logLevel, String message) {
        bpLogger.log(logLevel, message);
    }

    public static void logInit(String type){
        bpLogger.log(Level.INFO, type + " initialized!");
    }

    public static void logInfo(String message){
        bpLogger.log(Level.INFO, message);
    }
}
