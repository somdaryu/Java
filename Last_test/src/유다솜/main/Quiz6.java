package 유다솜.main;

public class Quiz6 {

	public static void main(String[] args) {
		Bolpen bolpen = new Bolpen();
		bolpen.chokSize = 2;
		bolpen.yang = "100%";
		bolpen.color = "파랑색";
		
		Manpen manpen = new Manpen();
		manpen.chokSize = 3;
		manpen.yang = "80%";
		manpen.brand = "몽블랑";
	}

}


class Pen {
	int chokSize;
	String yang;
}

class Bolpen extends Pen {
	String color;
}

class Manpen extends Pen {
	String brand;
}
