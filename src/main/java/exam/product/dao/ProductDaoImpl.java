package exam.product.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import exam.product.vo.ProductVo;

@Component
public class ProductDaoImpl implements ProductDao {

	// Mybatis�� SqlSession�� ����Ͽ� 
	// Connection, Statement�����ϰų�
	// ����ó���ϰų� ���ҽ� �����ϴ� �κ��� ���ӽ�Ŵ
	@Autowired
	private SqlSession sqlSession;
	
	// ProductMapper.xml�� ������ ���ִ� namespace
	private static String namespace = "exam.product.mapper.ProductMapper";
	
	@Override
	public ProductVo selectById(String id) {		
		List<ProductVo> products 
		= sqlSession.selectList(namespace + ".selectById", id);
		
		return products.isEmpty() ? null : products.get(0);
	}

	@Override
	public Collection<ProductVo> selectAll() {
		
		List<ProductVo> products 
		= sqlSession.selectList(namespace + ".selectAll");
		
		return products;
	}

	@Override
	public void update(ProductVo productVo) {
		sqlSession.update(namespace + ".update", productVo);

	}

	@Override
	public void insert(ProductVo productVo) {
		sqlSession.insert(namespace + ".insert", productVo);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete(namespace + ".delete", id);
		
	}

}























