package com.taotao.manager.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.manager.pojo.TbItem;

/**
 * 商品service的接口
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月22日 上午1:07:14
 * @version 1.0
 */
public interface TbItemService {

	TbItem selectTbItemById(Long id);
	EUDataGridResult queryAllItem(int page,int rows);
	
}