package com.axsos.zookeeper2;

public class Bat extends Mammal{
	public void fly() {
		System.out.println("the sound of a bat taking off");
		energyLevel-=50;
	}
	public void eatHumans() {
		System.out.println("the so- well, never mind");
		energyLevel+=25;
	}
	public void attackTown() {
		System.out.println("the sound of a town on fire");
		energyLevel-=100;
	}

}
