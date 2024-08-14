package shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class shop {

	public static void main(String[] args) throws IOException {
		 
		while (true) {
		
		Order.getCount();
		
		Scanner scanner = new Scanner(System.in);
		FileWriter fileWriter = new FileWriter("order.txt", true);
		
		System.out.println("1. 상품 주문하기");
		System.out.println("2. 전체 주문 이력 보기");
		System.out.println("3. 고객별 주문 이력 보기");
		System.out.println("4. 특정 날짜에 들어온 주문 이력 보기");
		System.out.println("5. 끝내기");
		System.out.println("옵션을 선택하세요: ");
		
		int num = 0;
		
		boolean validInput = false;
		while (!validInput) {
			try {
				num = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("1부터 5까지의 숫자 중에서 선택해 주세요.");
				System.out.println();
				scanner.next();
				System.out.println("1. 상품 주문하기");
				System.out.println("2. 전체 주문 이력 보기");
				System.out.println("3. 고객별 주문 이력 보기");
				System.out.println("4. 특정 날짜에 들어온 주문 이력 보기");
				System.out.println("5. 끝내기");
				System.out.println("옵션을 선택하세요: ");
			}
		}
		
		
		if (num == 1) {
			Order order = new Order();
			
			fileWriter.write("주문번호: " + order.count + ", ");
			scanner.nextLine();
			
			System.out.println("고객명: ");
			String name = scanner.nextLine();
			fileWriter.write("고객명: " + name + ", ");
			
			System.out.println("제품명: ");
			String product = scanner.nextLine();
			fileWriter.write("제품명: " + product + ", ");
			
			System.out.println("제품의 수량: ");
			String amount = scanner.nextLine();
			fileWriter.write("제품의 수량: " + amount + ", ");
			
			System.out.println("제품의 가격: ");
			String price = scanner.nextLine();
			fileWriter.write("제품의 가격: " + price + ", ");
			
			
			// 현재시간 가져오기
			LocalDateTime curDateTime = LocalDateTime.now();
			// 날짜를 특정포맷으로 출력하기
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formatDate = curDateTime.format(formatter);
			
			fileWriter.write("주문일시: " + formatDate + "\n");
			
			
			System.out.println("주문이 완료되었습니다!");	
			
			fileWriter.flush();
			fileWriter.close();
			
		} else if (num == 2) {
			
			String FILE_NAME = "order.txt";
					
					//FileReader: 입력 기반 스트림
					FileReader fr = new FileReader(FILE_NAME);
					//BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
					BufferedReader br = new BufferedReader(fr);
					//한줄씩 가져오기~
					
					
					while (true) {
						
						String line = br.readLine();
						
						// 파일의 끝에 도달하면 -1 반환
						if (line == null) {
							break;
						}
						
						System.out.println(line);
						
					}
			
		}  else if (num == 3) {
			scanner.nextLine();
			System.out.println("고객명: ");
			String name = scanner.nextLine();
			Get.getName(name);
			
		} else if (num == 4) {
			scanner.nextLine();
			System.out.println("날짜: ");
			String orderDate = scanner.nextLine();
			Get.getDate(orderDate);
			
		} else if (num == 5) {
			
			System.out.println("프로그램을 종료합니다.");
			break;
			
		} 
		
		System.out.println();

	}
		
	
	}

}




class Order {
	
	static int count = 0;
	public Order() {
		count++;
	}
	
	
	public static void getCount() throws IOException {
		
		
		String FILE_NAME = "order.txt";
		
		//FileReader: 입력 기반 스트림
		FileReader fr = new FileReader(FILE_NAME);
		//BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
		BufferedReader br = new BufferedReader(fr);
		//한줄씩 가져오기~
		
		
		int lastNum = 0;
		
		while (true) {
			
			String line = br.readLine();
			
			// 파일의 끝에 도달하면 -1 반환
			if (line == null) {
				break;
			}
			
				String[] arr = line.split(", ");
				
				for(int i = 0; i < arr.length; i++) {
					String o = arr[i];
					
					if (o.startsWith("주문번호: ")) {
						String[] arr2 = o.split(": ");
						
						lastNum = Integer.parseInt(arr2[1]);
					}
					
				}
			
		}
		
		count = lastNum;
		
		
		
	}
	
	
}



class Get {
	
public static void getName(String name) throws IOException {
		
		int customCount = 0;
		int totalPrice = 0;
		int customAmount = 0;
		
		String FILE_NAME = "order.txt";
		
		//FileReader: 입력 기반 스트림
		FileReader fr = new FileReader(FILE_NAME);
		//BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
		BufferedReader br = new BufferedReader(fr);
		//한줄씩 가져오기~
		
		
		while (true) {
			
			String line = br.readLine();
			
			// 파일의 끝에 도달하면 -1 반환
			if (line == null) {
				break;
			}
			
			if (line.contains(name)) {
				
				String[] arr = line.split(", ");
				
				for(int i = 0; i < arr.length; i++) {
					String o = arr[i];
					
					if (o.startsWith("고객명: ")) {
						String o2 = arr[i];
						customCount++;
					}
					
					if (o.startsWith("제품의 수량: ")) {
						String[] o2 = o.split(": ");
						customAmount = Integer.parseInt(o2[1]);
						
					}
					
					
					if (o.startsWith("제품의 가격: ")) {
						String[] o2 = o.split(": ");
						int price = Integer.parseInt(o2[1]);
						totalPrice = totalPrice + (customAmount * price);
						
						
					}
					
					
				}
				
			}
			
		}
		
		System.out.println("전체 주문 건수: " + customCount);
		System.out.println("전체 주문 금액: " + totalPrice);
		
	}
	
	public static void getDate(String orderDate) throws IOException {
		
		String FILE_NAME = "order.txt";
		
		//FileReader: 입력 기반 스트림
		FileReader fr = new FileReader(FILE_NAME);
		//BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
		BufferedReader br = new BufferedReader(fr);
		//한줄씩 가져오기~
		
		
		while (true) {
			
			String line = br.readLine();
			
			// 파일의 끝에 도달하면 -1 반환
			if (line == null) {
				break;
			}
			
			
			if (line.contains(orderDate)) {
				
				System.out.println(line);
				
			}
			
			
		}
		
		
			
	}
	
}




	
	