package kr.co.service;

import java.util.List;

import kr.co.domain.MemberVO;

public interface MemberService {

	public String getTime();

	public void insert(MemberVO vo);

	public List<MemberVO> list();

	public MemberVO read(String userid);

	public MemberVO updateUI(String userid);

	public int update(MemberVO vo);

	public int delete(MemberVO vo);

}
