package kr.co.ezen;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	/* method = RequestMethod.GET : 스프링상에서의 전송방식을 나타낼 때  */
	public String hello(Model model) {
		/* Model = request 와 비슷한 개념이라고 볼 수 있다 */
		/* MVC 핸들러 */
		logger.info("Welcome home! The client locale is {}.");
		
		/**
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		*/
		/* 해당 지역의 날짜 정보를 얻을 수 있는 class :  locale객체에 의해 지역정보를 가져 와 해당 지역에 맞는 날짜값을 가져올 수 있도록 해줌 */
		
		model.addAttribute("msg", "Morning" );
		
		return "good";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("serverTime", "ezen" );
		
		return "home";
	}
	
	@RequestMapping(value = "/world", method = RequestMethod.GET)
	public String world(Model model) {
		
		model.addAttribute("msg", "WORLD" );
		
		return "world";
	}
	
}
