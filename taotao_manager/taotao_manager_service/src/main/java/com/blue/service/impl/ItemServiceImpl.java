package com.blue.service.impl;

import com.blue.common.pojo.EasyUIDataGridResult;
import com.blue.common.pojo.TaotaoResult;
import com.blue.common.utils.IDUtils;
import com.blue.mapper.TbItemDescMapper;
import com.blue.mapper.TbItemMapper;
import com.blue.pojo.TbItem;
import com.blue.pojo.TbItemDesc;
import com.blue.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service.impl
 * @date 2018/1/26
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper descMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //分页查询
        //1.设置分页
        PageHelper.startPage(page,rows);//仅跟着的第一个查询会分页

        //查询所有
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);

        //构建分页对象, 里面包含了总记录数
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        long total = info.getTotal();

        //创建EasyUIDataGridResult, 封装(total,rows),页面需要的数据类型
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(total);
        result.setRows(info.getList());

        return result;
    }

    @Override
    public TaotaoResult saveItem(TbItem tbItem, String desc) {
        //注入mapper : tbItemMapper 和 tbItemDescMapper

        //1.生成商品的唯一id
        long itemId = IDUtils.genItemId();

        //2.补全商品其他属性
        tbItem.setId(itemId);
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(tbItem.getCreated());

//        3.商品的基本信息表
        tbItemMapper.insertSelective(tbItem);

        //4.创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();

        //5.补全itemDesc属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(tbItem.getCreated());
        itemDesc.setUpdated(tbItem.getCreated());

        //6.插入商品描述表
        descMapper.insertSelective(itemDesc);

        return TaotaoResult.ok();
    }
}
