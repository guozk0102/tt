package com.blue.controller;

import com.blue.common.pojo.TaotaoResult;
import com.blue.common.pojo.TreeNode;
import com.blue.pojo.TbContentCategory;
import com.blue.service.ContentCategoryService;
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
 * @date 2018/2/3
 */

@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<TreeNode> getContentCategoryByParentId(@RequestParam(value="id",defaultValue = "0") Long parentId){
        //1.引入服务
        //2.注入服务
        //3.调用
        return contentCategoryService.getContentCategoryListByParentId(parentId);
    }
    //url;/content/category/create
    //参数：parentId     name
    //返回值：json  里面要求有id的值  data.data.id
    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult saveContentCategory(TbContentCategory contentCategory){
        return  contentCategoryService.saveContentCategory(contentCategory);
    }
}
