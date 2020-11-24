package kr.co.tsuyu;

import com.naver.MemberDTO;
import com.naver.Test;

public class MainEx {

	public static void main(String[] args) {

		Test dao = new Test();
		
		 // dto.insert();
		
		MemberDTO dto = new MemberDTO("e008", "sung", "인사부");
		
		// dao.insert2(dto);
		
		//dao.delete(dto);
		
		dao.delete2();
	}

}
