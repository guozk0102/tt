package com.blue.controller;

import com.blue.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.controller
 * @date 2018/1/25
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/getNow")
    @ResponseBody
    public String getNow(){
        return testService.getNow();
    }
}
