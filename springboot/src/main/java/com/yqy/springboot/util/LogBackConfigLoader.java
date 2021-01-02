package com.yqy.springboot.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class LogBackConfigLoader {

    public static void load (String initxml) throws IOException, JoranException{
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(initxml.getBytes());

        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        configurator.doConfigure(tInputStringStream);
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);

    }

}
