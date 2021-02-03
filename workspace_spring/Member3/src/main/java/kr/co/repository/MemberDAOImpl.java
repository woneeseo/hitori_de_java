package kr.co.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	/* mybatis를 사용하려면 SqlSession객체를 통해서만 사용할 수 있다 */
	private final String NS = "kr.co.member";
	/* memberMapper에 선언해준 namespace의 값을 상수로 지정해 반복되는 코드를 최소화 해 줌 */

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(NS+".getTime");
		/* 여러개의 mapper를 생성하게 되면, 동일한 id를 가지고 있는 mapper끼리 헷갈릴 수 있으므로 
		 * namespace값을 함께 입력해 정확한 mapper를 사용할 수 있도록 함 */
	}

	@Override
	public void insert(MemberVO vo) {
		
		sqlSession.insert(NS+".insert", vo);
		/* 파라미터가 2개 : string형은 어떤 타입의 sql문을 사용할 것인가, object는 외부에서 입력되는 데이터를 동적으로 기능할 수 있게 함 */
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
	public void delete(MemberVO vo) {
		
		sqlSession.delete(NS+".delete", vo);
		
	}

	@Override
	public void update(MemberVO vo) {
		
		sqlSession.update(NS+".update", vo);
		
	}
	

}
