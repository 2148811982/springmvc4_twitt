package twitt.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import twitt.domain.Tweet;
import twitt.service.TweetService;

@Controller
@RequestMapping("twitt")
public class TweetController {

	@Autowired
	private TweetService twittService;
	
	@RequestMapping("search")
	public String search() {
		return "searchPage";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Tweet save(String title, String text) {
		Tweet result = twittService.save(title,text);
		return result;
	}
	
	@RequestMapping("allTwitts")
	public String allTwitts(Model model) {
		List<Tweet> twitts = twittService.findAll();
		model.addAttribute("tweets", twitts);
		return "resultPage";
	}
	
	@RequestMapping("twitts_after")
	@ResponseBody	
	public List<Tweet> twittsAfter(String time) throws ParseException {
		List<Tweet> twitts = twittService.queryAfter(time);
		return twitts;
	}
	
	@RequestMapping("searchResult")
	public String searchResult(String search, Model model) {
		List<Tweet> twitts = twittService.findByTitle(search);
		model.addAttribute("twitts", twitts);
		model.addAttribute("search", search);
		return "resultPage";
	}
}
