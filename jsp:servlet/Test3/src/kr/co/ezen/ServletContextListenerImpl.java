package kr.co.ezen;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// context가 종료되었을 때 실행할 것을 적는 곳
		System.out.println("어플리케이션 종료");
//		File f = new File("/Users/seoyewon/EZEN");
//		if(f.exists()) {
//			f.delete();
//		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// context를 초기화 했을 때 실행할 것을 적는 곳
		
		System.out.println("어플리케이션 시작");
//		File f = new File("/Users/seoyewon/EZEN");
//		if(!f.exists()) {
//			f.mkdir();
//		}
	}

}
