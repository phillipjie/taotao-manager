package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.service.TbItemService;

/**
 * 商品的controller层
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月22日 上午1:06:27
 * @version 1.0
 */
@Controller
public class TbItemController {
	@Autowired
	TbItemService tbItemService;


	//测试一个查询商品byid
	@RequestMapping("chaxun/{id}")
	@ResponseBody
	public TbItem selectTbItemById(@PathVariable Long id) {
		TbItem selectTbItemById = tbItemService.selectTbItemById(id);
		return selectTbItemById;
	}
}
