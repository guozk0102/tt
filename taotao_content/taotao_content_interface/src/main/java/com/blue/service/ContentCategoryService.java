package com.blue.service;

import com.blue.common.pojo.TaotaoResult;
import com.blue.common.pojo.TreeNode;
import com.blue.pojo.TbContentCategory;

import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service
 * @date 2018/2/2
 */
public interface ContentCategoryService {

    //根据父节点找到子节点列表
    public List<TreeNode> getContentCategoryListByParentId(Long perentId);

    //添加内容分类信息数据
    public TaotaoResult saveContentCategory(TbContentCategory contentCategory);

}
