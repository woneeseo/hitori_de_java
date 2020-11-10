package kr.co.tsuyu;

import java.util.Scanner;

import com.naver.Bow;
import com.naver.Gun;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.Sword;
import com.naver.Weapon;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Weapon[] weapons;
		Weapon w;
		
		weapons = new Weapon[]{
				new Bow("활", 1), new Sword("검", 5),
				new Gun("총", 10)
		};
		
		w = weapons[1];
		
		Hero hero = new Hero(weapons,w);
		Monster mon = new Monster(100);
		
		boolean isTrue = true;
		int menu = 0;
		int idx = 0;
		
		while(isTrue) {
			System.out.println("다음중 하나를 선택하세요.");
			System.out.println("0: 공격, 1: 무기변경, 2:종료");
			menu = sc.nextInt();
			
			if(menu==2) {
				break;
			}
			
			if(menu==0) {
				hero.attack(mon);
			}else if(menu==1) {
				System.out.println("무기를 선택하세요.");
				for(int i=0; i<weapons.length; i++) {
					System.out.print(i);
					System.out.print(" : "+weapons[i]+", ");
				}
				System.out.println();
				idx = sc.nextInt();
				sc.nextLine();
				hero.changeWeapon(idx);
				
			}
		}
		
		
		
		
		System.out.println("종료합니다.");
		
		sc.close();

	}

}
