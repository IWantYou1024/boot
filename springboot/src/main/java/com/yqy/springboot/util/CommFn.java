package com.yqy.springboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin7 on 2020/11/8.
 */
@Slf4j
@Component
public class CommFn {
    public static void staticLogAll(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("CommFn debug log");
        log.info("CommFn info log");
        log.warn("CommFn warn log");
        log.error("CommFn error log");
    }
    public  void logAll(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("CommFn debug log");
        log.info("CommFn info log");
        log.warn("CommFn warn log");
        log.error("CommFn error log");
    }
    public static String loadInitXml() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<configuration scan=\"true\" scanPeriod=\"60 seconds\" debug=\"false\">\n" +
                "\n" +
                "<!--设置变量-->\n" +
                "    <!--<property name=\"logback.logdir\" value=\"/Users/inke/dev/log/tomcat\"/>-->\n" +
                "    <!--<property name=\"logback.appname\" value=\"app\"/>-->\n" +
                "<!--application.yml 传递参数，不能使用logback 自带的<property>标签 -->\n" +
                "    <springProperty scope=\"context\" name=\"logback.appname\" source=\"logback.appname\"/>\n" +
                "    <springProperty scope=\"context\" name=\"logback.logdir\" source=\"logback.logdir\"/>\n" +
                "\n" +
                "\n" +
                "    <contextName>logback-demo</contextName>\n" +
                "\n" +
                "    <!--输出到控制台 ConsoleAppender-->\n" +
                "    <appender name=\"consoleLog\" class=\"ch.qos.logback.core.ConsoleAppender\">\n" +
                "        <!--展示格式 layout-->\n" +
                "        <layout class=\"ch.qos.logback.classic.PatternLayout\">\n" +
                "            <pattern>\n" +
                "                <pattern>%d{HH:mm:ss.SSS} %contextName [%thread] %-5level %logger{36} - %msg%n</pattern>\n" +
                "            </pattern>\n" +
                "        </layout>\n" +
                "    </appender>\n" +
                "\n" +
                "    <appender name=\"commInfo\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n" +
                "        <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则\n" +
                "            如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天\n" +
                "            的日志改名为今天的日期。即，<File> 的日志都是当天的。\n" +
                "        -->\n" +
                "        <File>${logback.logdir}/comm.log</File>\n" +
                "        <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->\n" +
                "        <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n" +
                "            <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->\n" +
                "            <FileNamePattern>${logback.logdir}/comm.%d{yyyy-MM-dd}.log</FileNamePattern>\n" +
                "            <!--只保留最近90天的日志-->\n" +
                "            <maxHistory>90</maxHistory>\n" +
                "            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->\n" +
                "            <!--<totalSizeCap>1GB</totalSizeCap>-->\n" +
                "        </rollingPolicy>\n" +
                "        <!--日志输出编码格式化-->\n" +
                "        <encoder>\n" +
                "            <charset>UTF-8</charset>\n" +
                "            <pattern>%d [%thread] %-5level %logger{36} %line - %msg%n</pattern>\n" +
                "        </encoder>\n" +
                "    </appender>\n" +
                "\n" +
                "    <appender name=\"utilInfo\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n" +
                "        <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则\n" +
                "            如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天\n" +
                "            的日志改名为今天的日期。即，<File> 的日志都是当天的。\n" +
                "        -->\n" +
                "        <File>${logback.logdir}/util.log</File>\n" +
                "        <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->\n" +
                "        <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n" +
                "            <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->\n" +
                "            <FileNamePattern>${logback.logdir}/util.%d{yyyy-MM-dd}.log</FileNamePattern>\n" +
                "            <!--只保留最近90天的日志-->\n" +
                "            <maxHistory>90</maxHistory>\n" +
                "            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->\n" +
                "            <!--<totalSizeCap>1GB</totalSizeCap>-->\n" +
                "        </rollingPolicy>\n" +
                "        <!--日志输出编码格式化-->\n" +
                "        <encoder>\n" +
                "            <charset>UTF-8</charset>\n" +
                "            <pattern>%d [%thread] %-5level %logger{36} %line - %msg%n</pattern>\n" +
                "        </encoder>\n" +
                "    </appender>\n" +
                "\n" +
                "    <!--logback.LogbackDemo：类的全路径 -->\n" +
                "    <logger name=\"com.yqy.springboot.controller\" level=\"INFO\" additivity=\"false\">\n" +
                "        <appender-ref ref=\"commInfo\"/>\n" +
                "    </logger>\n" +
                "    <!--指定最基础的日志输出级别-->\n" +
                "    <root level=\"INFO\">\n" +
                "        <!--appender将会添加到这个loger-->\n" +
                "        <appender-ref ref=\"consoleLog\"/>\n" +
                "    </root>\n" +
                "<!-- ___替换___ -->"+
                "</configuration>";
        return xml;
    }
    public static void reloadXml(String confLog){
        String initxml=loadInitXml();
        try {
            if(confLog!=null){
                initxml=initxml.replace("<!-- ___替换___ -->",confLog);
            }
            LogBackConfigLoader.load(initxml);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
