package exam.product.dao;

import java.util.Collection;

import exam.product.vo.ProductVo;

// Product�� ���� ���Ӽ� ó���ϴ� �������̽�
public interface ProductDao {
	// id�� �ش��ϴ� �ϳ��� Product�� ��ȸ
	public ProductVo selectById(String id);
	// ��� Product���� ��ȸ
	public Collection<ProductVo> selectAll();
	// Product�� ����
	public void update(ProductVo productVo);
	// Product�� ����
	public void insert(ProductVo productVo);
	// Product����
	public void delete(String id);	
}
