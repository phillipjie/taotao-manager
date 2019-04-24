package com.taotao.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TreeNode;
import com.taotao.manager.service.TbItemCatService;

/**
 * 
 * 商品类目的controller
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月24日 下午4:45:26
 * @version 1.0
 */
@Controller
public class TbItemCatController {
	@Autowired
	TbItemCatService tbItemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> selectTbItemCatByParenId(@RequestParam(value="id", defaultValue="0") Long pid) {
		List<TreeNode> list = tbItemCatService.selectTbItemCatByParentId(pid);
		return list;
	}
}
