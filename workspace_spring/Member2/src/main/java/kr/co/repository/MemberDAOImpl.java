package kr.co.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NS = "kr.co.member";

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(NS+".getTime");
	}

	@Override
	public void insert(MemberVO vo) {
		
		sqlSession.insert(NS+".insert", vo);
	}

	@Override
	public List<MemberVO> list() {
		
		return sqlSession.selectList(NS+".list");
	}

	@Override
	public MemberVO read(String userid) {
		
		return sqlSession.selectOne(NS+".read", userid);
	}

	@Override
	public int update(MemberVO vo) {
		
		int sucesseCount = sqlSession.update(NS+".update", vo);
		return sucesseCount;
	}

	@Override
	public int delete(MemberVO vo) {
		
		int successCount = sqlSession.delete(NS+".delete", vo);
		return successCount;
	}


}
