package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 为了通过左侧的菜单跳转到对应的jsp页面，所做的controller
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月22日 下午8:44:19
 * @version 1.0
 */
@Controller
public class PageController {
	//默认进入首页
	@RequestMapping(value = "/")
	private String indexPage() {
		return "index";
	}

	//进入对应功能的页面
	@RequestMapping(value = "{page}")
	private String goToPage(@PathVariable String page) {
		return page;
	}
	
}
