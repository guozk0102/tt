package com.blue.controller;

import com.blue.common.pojo.EasyUIDataGridResult;
import com.blue.common.pojo.TaotaoResult;
import com.blue.pojo.TbItem;
import com.blue.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.controller
 * @date 2018/1/26
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 分页查询商品列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        return itemService.getItemList(page, rows);
    }

    /**
     * 保存新增商品
     * @param tbItem
     * @param desc
     * @return
     */
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult saveItem(TbItem tbItem,String desc){
        return itemService.saveItem(tbItem, desc);
    }
}
