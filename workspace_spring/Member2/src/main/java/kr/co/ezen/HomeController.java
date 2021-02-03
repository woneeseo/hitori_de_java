package kr.co.ezen;


import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberVO;
import kr.co.service.MemberService;





/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(MemberVO vo) {
		
		int successCount = memberService.delete(vo);
		
		if (successCount >= 1) {
			return "redirect:/list";
		} else {
			return "redirect:/read/"+vo.getUserid();
		}

	}
	
	
	@RequestMapping(value = "deleteConfirm/{userid}", method = RequestMethod.GET)
	public String deleteConfirm(@PathVariable("userid") String userid, Model model) {
		
		model.addAttribute("userid", userid);
		return "delete";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberVO vo) {
		
		int successCount = memberService.update(vo);
		
		if (successCount >= 1) {
			return "redirect:/list";
		} else {
			return "redirect:/update/"+vo.getUserid();
		}
		/* update 메서드의 반환형을 int로 받는 이유 : update에 실패하면 0을 반환하고, 성공하면 1을 반환하기 때문에
		 * 성공했을 경우 / 실패했을 경우를 구분하여 처리할 수 있다. */

	}
	
	@RequestMapping(value = "update/{userid}", method = RequestMethod.GET)
	public String update(@PathVariable("userid") String userid, Model model) {
		/* spring에서 쿼리스트링을 사용하지 않고 파라미터를 넘겨주었을 때, @PathVariable("userid")로 넘겨받은 값을 가져오게 함 */
		/* 쿼리스트링 없이 path로 데이터를 넘겨주는 것을 선호하기 때문에 사용하는 방법이다 : 
		 * 주소창에 http://localhost:8089/update/m001 이런 모습으로 파라미터를 넘겨주게 된다 */

		MemberVO vo = memberService.updateUI(userid);
		model.addAttribute("vo", vo);
	
		return "update";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(String userid, Model model) {
		
		MemberVO vo = memberService.read(userid);
		model.addAttribute("vo", vo);

	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberVO> list = memberService.list();
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(MemberVO vo) {
		
		memberService.insert(vo);
		
		return "redirect:/list";
		
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public void getTime(Model model) {
		
		String time = memberService.getTime();
		model.addAttribute("time", time);
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