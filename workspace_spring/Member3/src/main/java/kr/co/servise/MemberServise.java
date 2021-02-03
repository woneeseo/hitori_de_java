package kr.co.servise;

import java.util.List;

import kr.co.domain.MemberVO;

public interface MemberServise {
	
	public String getTime();
	/* Servise는 DAO와 거의 같다 : 복붙이 가능한 수준 */

	public void insert(MemberVO vo);

	public List<MemberVO> list();

	public MemberVO read(String userid);

	public MemberVO updateUI(String userid);

	public void delete(MemberVO vo);

	public void update(MemberVO vo);



}
