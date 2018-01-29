package com.blue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.controller
 * @date 2018/1/26
 */
@Controller
public class PageController {

//    展示首页
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

//    点击跳转页面
//    url模板映射
    @RequestMapping("/{page}")
    public String shoeItemListPage(@PathVariable String page){
        return page;
    }
}
