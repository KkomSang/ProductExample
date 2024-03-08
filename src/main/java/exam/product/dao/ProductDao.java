package exam.product.dao;

import java.util.Collection;

import exam.product.vo.ProductVo;

// Product에 대한 영속성 처리하는 인터페이스
public interface ProductDao {
	// id에 해당하는 하나의 Product만 조회
	public ProductVo selectById(String id);
	// 모든 Product들을 조회
	public Collection<ProductVo> selectAll();
	// Product를 수정
	public void update(ProductVo productVo);
	// Product를 삽입
	public void insert(ProductVo productVo);
	// Product삭제
	public void delete(String id);	
}
