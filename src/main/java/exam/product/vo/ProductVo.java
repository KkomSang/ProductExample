package exam.product.vo;

import java.util.Date;

// 제품하나의 정보를 가지고 있는 Value Object
public class ProductVo {
	private String id; 	//제품 아이디
	private String name;	// 제품 이름
	private int price; 	//제품 가격
	private Date registerDate; 	// 제품 등록날짜
	
	
	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVo(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "제품정보 [id=" + id + ", name=" + name + ", price=" + price + ", registerDate=" + registerDate + "]";
	}
	
	

}
