package com.naver;

public class Weapon {
	
	private String name;
	private int power;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public Weapon(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public void attack(Monster mon) {
		int bHp=mon.getHp();
		int aHp = bHp-power;
		mon.setHp(aHp);
		System.out.println("몬스터의 HP : "+aHp);
	}

	@Override
	public String toString() {
		return getName();
		
	}
	
	

}
