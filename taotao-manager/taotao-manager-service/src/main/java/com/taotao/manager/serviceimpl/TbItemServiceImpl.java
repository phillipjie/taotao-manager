package com.taotao.manager.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.manager.mapper.TbItemMapper;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemExample;
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

	public EUDataGridResult queryAllItem(int page, int rows) {
		TbItemExample example=new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> selectByExample = tbItemMapper.selectByExample(example);
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(selectByExample);
		result.setTotal(new PageInfo<TbItem>(selectByExample).getTotal());
		return result;
	}
}
