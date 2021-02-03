package kr.co.ezen;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.repository.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testGetTime() {
		String str = dao.getTime();
		System.out.println(str);
	}

}
