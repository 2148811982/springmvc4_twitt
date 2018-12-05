package twitt.service;

import java.text.ParseException;
import java.util.List;

import twitt.domain.Tweet;

public interface TweetService {
	void saveAuto();
	Tweet save(String title, String text);
	List<Tweet> findAll();
	List<Tweet> findByTitle(String title);
	List<Tweet> queryAfter(String time) throws ParseException;
}
