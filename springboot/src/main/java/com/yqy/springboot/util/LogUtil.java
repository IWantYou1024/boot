package com.yqy.springboot.util;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import java.util.List;

/**
 * Created by admin7 on 2020/11/8.
 */
public class LogUtil {
    public static void setAllLogLevel(String level) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        for (Logger logger : loggerList) {
            logger.setLevel(Level.toLevel(level));
        }
    }

}