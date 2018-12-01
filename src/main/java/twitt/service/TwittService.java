package twitt.service;

import java.text.ParseException;
import java.util.List;

import twitt.domain.Twitt;

public interface TwittService {
	void saveAuto();
	Twitt save(String title, String text);
	List<Twitt> findAll();
	Twitt findByTitle(String title);
	List<Twitt> queryAfter(String time) throws ParseException;
}
