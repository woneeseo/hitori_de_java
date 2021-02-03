package kr.co.repository;

import java.util.List;

import kr.co.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();

	public void insert(MemberVO vo);

	public List<MemberVO> list();

	public MemberVO read(String userid);

	public void update(MemberVO vo);

	public void delete(MemberVO vo);


}
