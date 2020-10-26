package com.naver;

public class Car {
	
	private String modelName;
	private String carNo;
	private int price;
	public Car(String modelName, String carNo, int price) {
		super();
		this.modelName = modelName;
		this.carNo = carNo;
		this.price = price;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void showMePrice() {
		System.out.println(price);
		// 차의 가격을 가져오시오.
	}
	
	public String run(int speed) {
		String a = speed +"의 속도로 달린다.";
		return a;
		// speed 의 속도로 달린다. 를 반환하시오.
	}
	
	

}
