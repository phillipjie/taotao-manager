package com.taotao.manager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manager.mapper.TbItemMapper;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.service.TbItemService;

/**
 * 商品的service层
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月22日 上午1:01:26
 * @version 1.0
 */
@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	TbItemMapper tbItemMapper;
	
	public TbItem selectTbItemById(Long id) {
		TbItem selectByPrimaryKey = tbItemMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
		
	}
}
