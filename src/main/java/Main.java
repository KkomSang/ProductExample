import org.springframework.context.support.GenericXmlApplicationContext;

import exam.product.ui.ProductUI;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		ProductUI productUI = (ProductUI)ctx.getBean("productUI");
		productUI.showMenu();
	}
}
