package kr.co.ezen;


import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberVO;
import kr.co.servise.MemberServise;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private MemberServise memberServise;
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(MemberVO vo) {
		
		memberServise.delete(vo);
		
		return "redirect:/list";

	}
	
	
	@RequestMapping(value = "deleteConfirm/{userid}", method = RequestMethod.GET)
	public String deleteConfirm(@PathVariable("userid") String userid, Model model) {
		
		model.addAttribute("userid", userid);
		return "delete";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberVO vo) {
		
		memberServise.update(vo);
		return "redirect:/read"+vo.getUserid();
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(@PathVariable("userid") String userid, Model model) {
		
		MemberVO vo = memberServise.updateUI(userid);
		model.addAttribute("vo", vo);
		
		return "update";	
	}
	
	@RequestMapping(value = "read/{userid}", method = RequestMethod.GET)
	public String read(@PathVariable("userid") String userid, Model model) {
		
		MemberVO vo = memberServise.read(userid);
		model.addAttribute("vo", vo);
		
		return "read";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberVO> list = memberServise.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		
		return "insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(MemberVO vo) {
		
		memberServise.insert(vo);
		
		return "redirect:/getTime";
	}
	
	/* 메서드 이름이 같아도 되는 이유? 메서드 오버로딩을 이용함 */
	
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public String getTime(Model model) {
		
		String time = memberServise.getTime();
		model.addAttribute("time", time);

		return "getTime";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

//      Date date = new Date();
//      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//      
//      String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", "ezen");

		return "home";
	}

}