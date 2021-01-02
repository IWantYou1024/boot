package com.yqy.springboot.controller;

import com.yqy.springboot.util.CommFn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin7 on 2020/11/8.
 */
@RestController
@Slf4j
public class DemoController {
    @Autowired
    private CommFn commFn;
    @GetMapping("/gethello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        commFn.logAll();
        CommFn.staticLogAll();
        return String.format("Hello %s!", name);
    }
    @RequestMapping("/")
    public static String testControll() {
        return "test_url_内容";
    }
}
