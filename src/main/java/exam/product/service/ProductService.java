package exam.product.service;

import java.util.Collection;

import exam.product.vo.ProductVo;

// �����Ͻ� ������ ó���ϴ� ���� layer
public interface ProductService {
	// ��ǰ�� ����ϴ� ����
	public void registerProduct(ProductVo productVo);
	// ��ǰ�� ��ȸ�ϴ� ����
	public ProductVo getProduct(String id);
	// ��ǰ�� �����ϴ� ����
	public void removeProduct(String id);
	// ��ǰ�� ������ �����ϴ� ����
	public void changeProductPrice(ProductVo productVo);
	// ��ü ��ǰ ����� ��ȸ�ϴ� ����
	public Collection<ProductVo> getProducts();
}
