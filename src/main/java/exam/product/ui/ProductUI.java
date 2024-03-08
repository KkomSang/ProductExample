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

	// ProductSerive�� ������
	@Autowired
	private ProductService productService;

	// ProductSerivce�� ������ setter
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void showMenu() {
		Scanner scan = new Scanner(System.in);
		String command = "";
		
		while(true) {
			System.out.println("��ɾ �Է��ϼ���: ");
			command = scan.nextLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
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
			System.out.println("��ǰ�� �����Ͽ����ϴ�.\n");
		}catch (ProductNotFountException e) {
			System.out.println("��ǰ�� �������� �ʽ��ϴ�.\n");
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
			System.out.println("��ǰ ������ �����Ͽ����ϴ�.\n");
		}catch (ProductNotFountException e) {
			System.out.println("��ǰ�� �������� �ʽ��ϴ�.\n");
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
			System.out.println("��ǰ�� �������� �ʽ��ϴ�.\n");
		}
	}

	private void processNewCommand(String[] args) {
		// new��ɾ �߸� �ԷµǾ�����
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ProductVo product = 
				new ProductVo(args[1], args[2], Integer.parseInt(args[3]));
		
		try {
			productService.registerProduct(product);
		}catch (AlreadyExistingProductException e) {
			System.out.println("�̹� �����ϴ� ��ǰ�Դϴ�.\n");
		}		
	}

	private void printHelp() {
		System.out.println();
		System.out.println("�߸��� ��ɾ��Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("��ɾ� ����");
		System.out.println("new ��ǰ���̵� ��ǰ�̸� ����");
		System.out.println("search ��ǰ���̵�");
		System.out.println("change ��ǰ���̵� �����Ұ���");
		System.out.println("delete ��ǰ���̵�");
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







