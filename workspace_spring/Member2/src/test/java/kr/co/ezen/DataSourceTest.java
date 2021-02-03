package kr.co.ezen;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
/* spring 폴더 안에 있는 servlet-context / root-context를 모두 참조하고 싶을 때 쓰는 location */
/* spring 폴더 안에는 appServlet이라는 폴더와, root-context라는 xml파일이 존재한다.
 * appServlet을 더블클릭해 들어가야, servlet-context가 나온다 : 두 xml파일이 저장된 곳이 서로 다름 */
/* 따라서, 두 파일 다 참조할 수 있도록 하려면, 
 * ** -> 폴더가 있던지 없던지 상관없다. / *.xml : 확장자가 xml인 모든 파일을 참조한다. */
public class DataSourceTest {
	/* @Autowird 도 가능하다 (inject와 같은 역할) */

	@Inject
	/* spring 컨테이너가 관리하고 있는 객체를 가져와서 값을 대입해줌 */
	/* 만약 inject가 없으면 DataSource로 변수를 선언했을 때 값이 null이 된다 */
	/* inject 어노테이션을 선언해주면, root-context.xml에서 선언한 자료형이 
	 * DataSource인 객체의 값을 불러와 ds에 대입해 주기 때문에, 
	 * dataSource에 설정한 프로퍼티 값을 모두 사용할 수 있다 */
	private DataSource ds;

	@Test
	public void testConection() {
		Connection conn = null;

		try {
			conn = ds.getConnection();
			System.out.println("connection 생성");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
