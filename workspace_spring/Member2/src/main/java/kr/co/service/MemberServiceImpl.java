package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.MemberVO;
import kr.co.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String getTime() {
		
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
		/* 서비스에서 read를 사용해도 되는 이유 : 트랜잭션이 발생하면 service에서 처리해주기 때문에 */
	}

	@Override
	public int update(MemberVO vo) {
		
		int sucessCount = memberDAO.update(vo);
		return sucessCount;
	}

	@Override
	public int delete(MemberVO vo) {
		
		int successCount = memberDAO.delete(vo);
		return successCount;
	}


}
