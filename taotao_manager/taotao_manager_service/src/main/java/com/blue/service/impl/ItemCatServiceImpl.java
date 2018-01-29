package com.blue.service.impl;

import com.blue.common.pojo.TreeNode;
import com.blue.mapper.TbItemCatMapper;
import com.blue.pojo.TbItemCat;
import com.blue.pojo.TbItemCatExample;
import com.blue.pojo.TbItemExample;
import com.blue.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service.impl
 * @date 2018/1/29
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(Long parentId) {
        //1.注入mapper
        //2.创建example,封装查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        //3,执行查询,获取结果List<tbitemcat>
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);

        //4.转成List<TreeNode>返回结果
        List<TreeNode> nodes = new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemCats) {
            TreeNode node = new TreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");

            nodes.add(node);
        }
        return nodes;
    }
}
