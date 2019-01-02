package twitt.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import twitt.domain.Tweet;
import twitt.service.ITweetService;

@Controller
@RequestMapping("tweet")
public class TweetController {

	@Autowired
	private ITweetService tweetService;
	
	@RequestMapping("search")
	public String search() {
		return "searchPage";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Tweet save(String title, String text, long userId) {
		Tweet result = tweetService.save(title,text,userId);
		return result;
	}
	
	@RequestMapping("allTweets")
	public String allTwitts(Model model) {
		List<Tweet> tweets = tweetService.findAll();
		model.addAttribute("tweets", tweets);
		return "resultPage";
	}
	
	@RequestMapping("twittsAfter")
	@ResponseBody	
	public List<Tweet> twittsAfter(String time) throws ParseException {
		List<Tweet> tweets = tweetService.queryAfter(time);
		return tweets;
	}
	
	@RequestMapping("searchResult")
	public String searchResult(String search, Model model) {
		List<Tweet> tweets = tweetService.findByTitle(search);
		model.addAttribute("tweets", tweets);
		model.addAttribute("search", search);
		return "resultPage";
	}
}
