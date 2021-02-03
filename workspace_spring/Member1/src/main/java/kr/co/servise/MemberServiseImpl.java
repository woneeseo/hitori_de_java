package kr.co.servise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.MemberVO;
import kr.co.repository.MemberDAO;

@Service
public class MemberServiseImpl implements MemberServise{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return memberDAO.getTime();
	}

	@Override
	public void insert(MemberVO vo) {
		
		memberDAO.insert(vo);
		
	}

	@Override
	public List<MemberVO> list() {
		
		return memberDAO.list();
	}

	@Override
	public MemberVO read(String userid) {
		
		return memberDAO.read(userid);
	}

	@Override
	public MemberVO updateUI(String userid) {
		
		return memberDAO.read(userid);
	}

	@Override
	public void update(MemberVO vo) {
		
		memberDAO.update(vo);
		
	}

	@Override
	public void delete(MemberVO vo) {
		memberDAO.delete(vo);
	}


}
