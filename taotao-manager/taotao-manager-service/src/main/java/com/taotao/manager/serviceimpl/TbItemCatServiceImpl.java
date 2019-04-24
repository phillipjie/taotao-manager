package com.taotao.manager.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TreeNode;
import com.taotao.manager.mapper.TbItemCatMapper;
import com.taotao.manager.pojo.TbItemCat;
import com.taotao.manager.pojo.TbItemCatExample;
import com.taotao.manager.pojo.TbItemCatExample.Criteria;
import com.taotao.manager.service.TbItemCatService;

/**
 * 商品类目的service
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月24日 下午4:22:30
 * @version 1.0
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	@Autowired
	TbItemCatMapper tbItemCatMapper;
	
	//通过父节点id查询商品类目
	public List<TreeNode> selectTbItemCatByParentId(Long pid) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(pid);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List<TreeNode> res=new ArrayList();
		for(TbItemCat tbItemCat:list) {
			TreeNode tn=new TreeNode();
			tn.setId(tbItemCat.getId());
			tn.setText(tbItemCat.getName());
			tn.setState(tbItemCat.getIsParent()?"closed":"open");
			res.add(tn);
		}
		return res;
	}
	
}
