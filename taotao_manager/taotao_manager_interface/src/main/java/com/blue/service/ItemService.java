package com.blue.service;

import com.blue.common.pojo.EasyUIDataGridResult;
import com.blue.common.pojo.TaotaoResult;
import com.blue.pojo.TbItem;

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

    /**
     * 保存新增商品
     * @param tbItem
     * @param desc
     * @return
     */
    public TaotaoResult saveItem(TbItem tbItem,String desc);
}
