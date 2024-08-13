package 유다솜.main;

public class Quiz3 {

	public static void main(String[] args) {
		int i;
		int sum = 0;
		for(i=1; i<100; i++) {
			sum = sum + i;
			if(sum >=300) {
				break;
			}
		}
		System.out.println("i:"+i+", sum:"+sum);
	}

}
