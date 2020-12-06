package sec04.exam03_properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		
		Properties properties = new Properties();
		
		String path = PropertiesExample.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		
		
		System.out.println("driver: "+driver);
		System.out.println("url: "+url);
		
		/* properties 라는 확장자명을 가진 파일이 존재할 경우,
		 * properties map 컬렉션을 사용하면 값을 가져오는 것이 가능하다. */

	}

}
