package com.blue.service.impl;

import com.blue.common.pojo.EasyUIDataGridResult;
import com.blue.mapper.TbItemMapper;
import com.blue.pojo.TbItem;
import com.blue.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
