package twitt.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import twitt.domain.Twitt;
import twitt.service.TwittService;

@Controller
@RequestMapping("twitt")
public class TwittController {

	@Autowired
	private TwittService twittService;
	
	@RequestMapping("save_auto")
	@ResponseBody
	public void saveAuto() {
		
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Twitt save(String title, String text) {
		Twitt result = twittService.save(title,text);
		return result;
	}
	
	@RequestMapping("allTwitts")
	public String allTwitts(Model model) {
		List<Twitt> twitts = twittService.findAll();
		model.addAttribute("tweets", twitts);
		return "resultPage";
	}
	
	@RequestMapping("twitt_bytitle")
	@ResponseBody
	public Twitt twittByTitle(String title) {
		Twitt t = twittService.findByTitle(title);
		return t;
	}
	
	@RequestMapping("twitts_after")
	@ResponseBody	
	public List<Twitt> twittsAfter(String time) throws ParseException {
		List<Twitt> twitts = twittService.queryAfter(time);
		return twitts;
	}
}
