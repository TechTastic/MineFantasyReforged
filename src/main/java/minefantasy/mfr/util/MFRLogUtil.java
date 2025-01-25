package minefantasy.mfr.util;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class MFRLogUtil {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void log(String log) {
        LOGGER.info(log);
    }

    public static void logWarn(String warn) {
        LOGGER.warn(warn);
    }

    public static void logDebug(String debug) {
        LOGGER.debug(debug);
    }
}
