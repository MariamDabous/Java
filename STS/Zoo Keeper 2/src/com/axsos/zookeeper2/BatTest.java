package com.axsos.zookeeper2;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat b = new Bat();
		b.attackTown();
		b.attackTown();
		b.attackTown();
		b.eatHumans();
		b.eatHumans();
		b.fly();
		b.fly();
		System.out.println(b.displayEnergy());
	}

}
