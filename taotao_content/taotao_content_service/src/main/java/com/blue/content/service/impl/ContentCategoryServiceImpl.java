package com.blue.content.service.impl;

import com.blue.common.pojo.TaotaoResult;
import com.blue.common.pojo.TreeNode;
import com.blue.mapper.TbContentCategoryMapper;
import com.blue.pojo.TbContentCategory;
import com.blue.pojo.TbContentCategoryExample;
import com.blue.pojo.TbContentExample;
import com.blue.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description 内容分类
 * @date 2018/2/2
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper mapper;

    @Override
    public List<TreeNode> getContentCategoryListByParentId(Long perentId) {
         //1.创建example, 设置查询条件
        TbContentCategoryExample example = new TbContentCategoryExample();
        example.createCriteria().andParentIdEqualTo(perentId);
        //2.执行查询 list<tbcontentcategoy>
        List<TbContentCategory> categories = mapper.selectByExample(example);
        List<TreeNode> nodes = new ArrayList<>();
        for (TbContentCategory category : categories) {
            TreeNode node = new TreeNode();
            node.setId(category.getId());//节点的id
            node.setText(category.getName());
            node.setState(category.getIsParent()?"closed":"open");
            nodes.add(node);
        }
        //3.转成List<treenode
        return nodes;
    }

    @Override
    public TaotaoResult saveContentCategory(TbContentCategory contentCategory) {
        //1.补全属性
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(contentCategory.getCreated());
        contentCategory.setIsParent(false);//叶子
        contentCategory.setSortOrder(1);
        contentCategory.setStatus(1);


        //如果添加的节点其父节点原来就是一个叶子节点就需要更新成父节点
        TbContentCategory newNodeParentcategory = mapper.selectByPrimaryKey(contentCategory.getParentId());

        if(!newNodeParentcategory.getIsParent()){
            newNodeParentcategory.setIsParent(true);
            mapper.updateByPrimaryKey(newNodeParentcategory);
        }


        //2.插入数据
        mapper.insertSelective(contentCategory);
        //3.返回taotaoresult ---》date属性指定 contentCategory对象
        //contentCategory 该对象就有id的值
        return TaotaoResult.ok(contentCategory);
    }
}
