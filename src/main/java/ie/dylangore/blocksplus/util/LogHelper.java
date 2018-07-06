package ie.dylangore.blocksplus.util;

import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Project: BlocksPlus
 * File: LogHelper
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
@SuppressWarnings("unused")
public class LogHelper {

    private static final Logger logger = LogManager.getLogger("BlocksPlus");

    private static void log(Level logLevel, Object object) {
        logger.log(logLevel, String.valueOf(object));

    }

    public static void all(Object object) {
        log(Level.ALL, object);
    }

    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }

    public static void error(Object object) {
        log(Level.ERROR, object);
    }

    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void off(Object object) {
        log(Level.OFF, object);
    }

    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

    public static void warn(Object object) {
        log(Level.WARN, object);
    }

    public static void bigWarning(Object object){
        FMLLog.bigWarning(String.valueOf(object));
    }

}
