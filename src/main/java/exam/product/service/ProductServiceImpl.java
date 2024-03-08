package exam.product.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exam.product.dao.ProductDao;
import exam.product.vo.ProductVo;

@Component
public class ProductServiceImpl implements ProductService {
	// ProductDao에 의존함
	@Autowired
	private ProductDao productDao;
	
	// ProductDao를 주입할 생성자
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public void registerProduct(ProductVo newProduct) {
		ProductVo product = productDao.selectById(newProduct.getId());
		
		if(product != null) {
			throw new AlreadyExistingProductException();
		}
		
		newProduct.setRegisterDate(new Date());
		productDao.insert(newProduct);
	}

	@Override
	public ProductVo getProduct(String id) {
		ProductVo product = productDao.selectById(id);
		
		if(product == null) {
			throw new ProductNotFountException();
		}
		
		return product;
	}

	@Override
	public void removeProduct(String id) {
		ProductVo product = productDao.selectById(id);
		
		if(product == null) {
			throw new ProductNotFountException();
		}
		
		productDao.delete(id);
	}

	@Override
	public void changeProductPrice(ProductVo updateProduct) {
		ProductVo product = productDao.selectById(updateProduct.getId());
		
		if(product == null) {
			throw new ProductNotFountException();
		}
		
		updateProduct.setName(product.getName());
		updateProduct.setRegisterDate(product.getRegisterDate());
	
		productDao.update(updateProduct);
	}

	@Override
	public Collection<ProductVo> getProducts() {
		return productDao.selectAll();
	}

}










