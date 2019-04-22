package com.taotao.manager.mapper;
/**
 * 
 * 
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月21日 下午8:24:56
 * @version 1.0
 */

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.taotao.manager.pojo.TbItem;

public class MapperTest {
	
	@Test
	public void selectItemInfo() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatiscon.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sessionFactory.openSession();
		TbItemMapper mapper = sqlSession.getMapper(com.taotao.manager.mapper.TbItemMapper.class);
		Long a=(long) 816753;
		TbItem b = mapper.selectByPrimaryKey(a);
		System.out.println(b);
	}
}
