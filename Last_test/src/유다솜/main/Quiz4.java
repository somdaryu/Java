package 유다솜.main;

public class Quiz4 {

	public static void main(String[] args) {
		int[] arr1= new int[] {2, 4, 6, 8, 10};
		System.out.println("첫번째 배열의 합계: "+ addArr(arr1));
		
		int[] arr2 = new int[] {2, 4};
		System.out.println("두번째 배열의 합계: "+addArr(arr2));
	}

	
	
	public static int addArr(int[] a) {
		int sum = 0;
		if(a.length<=3) {
			return -999;
		}else {
		for(int i=0; i<a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
		}
	}
}
