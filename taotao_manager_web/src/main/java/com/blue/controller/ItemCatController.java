package com.blue.controller;

import com.blue.common.pojo.TreeNode;
import com.blue.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.controller
 * @date 2018/1/29
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;


    @RequestMapping("/item/cat/list")//页面传过来的是被点击的节点 id
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<TreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }
}

