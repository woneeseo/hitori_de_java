package com.nate;

import com.naver.Car;
import com.naver.Dog;

import kr.co.ezen.Person;

public class Team {
	
	private Person captain;
	private Person member1;
	private Person member2;
	public Team(Person captain, Person member1, Person member2) {
		super();
		this.captain = captain;
		this.member1 = member1;
		this.member2 = member2;
	}
	public Person getCaptain() {
		return captain;
	}
	public void setCaptain(Person captain) {
		this.captain = captain;
	}
	public Person getMember1() {
		return member1;
	}
	public void setMember1(Person member1) {
		this.member1 = member1;
	}
	public Person getMember2() {
		return member2;
	}
	public void setMember2(Person member2) {
		this.member2 = member2;
	}
	
	public void showCaptainCarPrice() {
	 
		Car car = captain.getK7();
		car.showMePrice();
	}
	
	public void mem1Sleep(String where) {
		Dog dog = member1.getHappy();
		System.out.println(dog.sleep(where));
		
	}
	
	public void mem2CarModelName() {
		Car cn = member2.getK7();
		String m2cn = cn.getModelName();
		System.out.println(m2cn);
		
	}
	
	public void capDogName() {
		String dn = captain.getHappy().getName();
		System.out.println(dn);
	}
	
	public void mem1CarPrice() {
		Car c = member1.getK7();
		int m1cp = c.getPrice();
		System.out.println(m1cp); 
		
		
	}

}
