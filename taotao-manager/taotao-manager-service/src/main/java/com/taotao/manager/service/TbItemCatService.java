package com.taotao.manager.service;

import java.util.List;

import com.taotao.common.pojo.TreeNode;

/**
 * 
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月24日 下午4:42:48
 * @version 1.0
 */
public interface TbItemCatService {

	//通过父节点id查询商品类目
	List<TreeNode> selectTbItemCatByParentId(Long pid);

}