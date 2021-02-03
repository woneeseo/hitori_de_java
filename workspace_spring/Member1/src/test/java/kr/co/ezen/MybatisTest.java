package kr.co.ezen;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MybatisTest {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	/* Autowired나 inject 어노테이션이 있을 경우, 스프링이 다루고 있는 빈 안에서 같은 자료형을 가지는 빈객체가 있으면
	 * 해당 빈 객체와 연결해 값을 가질 수 있게 해줌 : 해당 어노테이션이 없으면 객체값은 null을 가진다 */
	@Test
	public void testFactory() {
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		System.out.println(sqlFactory);
		System.out.println("::::::::::::::::::::::::::::::::::::::::");		
	}
	
	@Test
	public void testSession() {
		SqlSession session = sqlFactory.openSession();
		System.out.println(session);
		session.close();
	}

}
