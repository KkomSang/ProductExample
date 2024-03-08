package exam.product.vo;

import java.util.Date;

// ��ǰ�ϳ��� ������ ������ �ִ� Value Object
public class ProductVo {
	private String id; 	//��ǰ ���̵�
	private String name;	// ��ǰ �̸�
	private int price; 	//��ǰ ����
	private Date registerDate; 	// ��ǰ ��ϳ�¥
	
	
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
		return "��ǰ���� [id=" + id + ", name=" + name + ", price=" + price + ", registerDate=" + registerDate + "]";
	}
	
	

}
