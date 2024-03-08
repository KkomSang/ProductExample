package exam.product.service;

import java.util.Collection;

import exam.product.vo.ProductVo;

// 비지니스 로직을 처리하는 서비스 layer
public interface ProductService {
	// 제품을 등록하는 서비스
	public void registerProduct(ProductVo productVo);
	// 제품을 조회하는 서비스
	public ProductVo getProduct(String id);
	// 제품을 삭제하는 서비스
	public void removeProduct(String id);
	// 제품의 가격을 변경하는 서비스
	public void changeProductPrice(ProductVo productVo);
	// 전체 제품 목록을 조회하는 서비스
	public Collection<ProductVo> getProducts();
}
