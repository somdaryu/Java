package 유다솜.main;

import java.util.ArrayList;

public class Quiz7 {

	public static void main(String[] args) {
		ArrayList<Animal> list = new ArrayList<>();
		list.add(new Human());
		list.add(new Tiger()); 
		for(Animal a : list) {
			a.sleep();
			if(a instanceof Human) {
				Human human = (Human)a;
				human.move();
				human.readBook();
			}else if(a instanceof Animal) {
				Tiger tiger = (Tiger)a;
				tiger.move();
				tiger.hunting();
			}System.out.println();
	}
	}

}

abstract class Animal {
	public void sleep() {
		System.out.println("밤에는 잠을 잡니다.");
	};
	abstract public void move();
}

class Human extends Animal {

	@Override
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal {

	@Override
	public void move() {
		System.out.println("호랑이가 네발로 뜁니다.");
	}
	
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
	
}
