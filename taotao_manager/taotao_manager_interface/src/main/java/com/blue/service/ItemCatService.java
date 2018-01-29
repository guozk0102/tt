package com.blue.service;

import com.blue.common.pojo.TreeNode;

import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service
 * @date 2018/1/29
 */
public interface ItemCatService {
    /**
     * 根据父节点id,查询该父节点下所有子节点的列表
     * @param parentId
     * @return
     */
    public List<TreeNode> getItemCatList(Long parentId);
}
