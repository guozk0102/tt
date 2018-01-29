package com.blue.service;

import com.blue.common.pojo.EasyUIDataGridResult;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service
 * @date 2018/1/26
 */
public interface ItemService {
    /**
     * 分页查询商品的列表
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
