package exam.product.ui;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exam.product.service.AlreadyExistingProductException;
import exam.product.service.ProductNotFountException;
import exam.product.service.ProductService;
import exam.product.vo.ProductVo;

@Component
public class ProductUI {

	// ProductSerive에 의존함
	@Autowired
	private ProductService productService;

	// ProductSerivce를 주입할 setter
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void showMenu() {
		Scanner scan = new Scanner(System.in);
		String command = "";
		
		while(true) {
			System.out.println("명령어를 입력하세요: ");
			command = scan.nextLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(command.equalsIgnoreCase("list")) {
				processListCommand();
				continue;
			}else if(command.toLowerCase().startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.toLowerCase().startsWith("search ")) {
				processSearchCommand(command.split(" "));
				continue;
			}else if(command.toLowerCase().startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if(command.toLowerCase().startsWith("delete ")) {
				processDeleteCommand(command.split(" "));
				continue;
			}
			printHelp();
			
		}
	}

	private void processDeleteCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		
		try {
			productService.removeProduct(args[1]);
			System.out.println("제품을 삭제하였습니다.\n");
		}catch (ProductNotFountException e) {
			System.out.println("제품이 존재하지 않습니다.\n");
		}
	}

	private void processChangeCommand(String[] args) {
		if(args.length != 3) {
			printHelp();
			return;
		}
		
		ProductVo product =
				new ProductVo(args[1], "", Integer.parseInt(args[2]));
		
		try {
			productService.changeProductPrice(product);
			System.out.println("제품 가격을 변경하였습니다.\n");
		}catch (ProductNotFountException e) {
			System.out.println("제품이 존재하지 않습니다.\n");
		}
		
	}

	private void processSearchCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		
		try {
			ProductVo product = productService.getProduct(args[1]);
			System.out.println(product);
		}catch (ProductNotFountException e) {
			System.out.println("제품이 존재하지 않습니다.\n");
		}
	}

	private void processNewCommand(String[] args) {
		// new명령어가 잘못 입력되었으면
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ProductVo product = 
				new ProductVo(args[1], args[2], Integer.parseInt(args[3]));
		
		try {
			productService.registerProduct(product);
		}catch (AlreadyExistingProductException e) {
			System.out.println("이미 존해하는 제품입니다.\n");
		}		
	}

	private void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령어입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법");
		System.out.println("new 제품아이디 제품이름 가격");
		System.out.println("search 제품아이디");
		System.out.println("change 제품아이디 변경할가격");
		System.out.println("delete 제품아이디");
		System.out.println("list");
		System.out.println();
	}

	private void processListCommand() {
		Collection<ProductVo> products = productService.getProducts();
		
		for(ProductVo product : products) {
			System.out.println(product);
		}
		
	}
	
	
}







