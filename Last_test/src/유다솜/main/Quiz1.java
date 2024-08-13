package 유다솜.main;

public class Quiz1 {

	public static void main(String[] args) {
		int math = 90;
		int eng = 70;
		int ko = 100;
		
		int sum = math + eng + ko;
		double avg = (double)sum / 3;
		
		System.out.println("총점:"+sum);
		System.out.println("평균:" + avg);

	}

}
