package com.yqy.springboot.controller;

import com.yqy.springboot.util.CommFn;
import com.yqy.springboot.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin7 on 2020/11/8.
 */

@RestController
@Slf4j
public class LogController {
    /**
     * 测试日志等级
     *
     * @return
     */
    @RequestMapping("/loglevel")
    public String logLevel() {
        log.debug("LogController debug log");
        log.info("LogController info log");
        log.warn("LogController warn log");
        log.error("LogController error log");
        return "success";
    }

    /**
     * 设置日志等级
     *
     * @param level
     * @param packages
     * @return
     */
    @RequestMapping("/changeLog/{level}")
    public String changeLog(@PathVariable String level, @RequestBody String packages) {
        if (StringUtils.isEmpty(packages)) {
            LogUtil.setAllLogLevel(level);
        }
//        else {
//            LogUtil.setLogLevel(packages, level);
//        }
        return "success";
    }
    /**
     * 设置日志等级
     *
     * @param level
     * @return
     */
    @RequestMapping("/changeLevel/{level}")
    public String changeLevel(@PathVariable String level) {

            LogUtil.setAllLogLevel(level);
        return "success";
    }
    @RequestMapping("/addlog/{level}")
    public String addlog(@PathVariable String level) {
        String addLog="    <logger name=\"com.yqy.springboot.util\" level=\""+level+"\" additivity=\"false\">\n" +
                "        <appender-ref ref=\"utilInfo\"/>\n" +
                "    </logger>\n" ;
        CommFn.reloadXml(addLog);
        return "success";
    }
}
