package twitt.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import twitt.dao.TweetDao;
import twitt.domain.TwUser;
import twitt.domain.Tweet;
import utils.TweetUtils;

@Service
public class TweetServiceImpl implements ITweetService {
	
	@Autowired
	private TweetDao tweetDao;

	@Override
	@Cacheable(value = "tweets")
	public List<Tweet> findAll() {
		List<Tweet> twitts = tweetDao.findAll();
		return twitts;
	}

	@Override
	@Cacheable(value = "tweets", key = "#title")
	public List<Tweet> findByTitle(String title) {
		List<Tweet> twitts = tweetDao.findByTitle(title);
		return twitts;
	}

	@Override
	@Cacheable(value = "tweets", key = "#timeStr")
	public List<Tweet> queryAfter(String timeStr) throws ParseException {
		DateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date time = f.parse(timeStr);
		List<Tweet> twitts = tweetDao.queryAfter(time);
		return twitts;
	}

	@Override
	@CacheEvict(value = "tweets")
	public Tweet save(String title, String text, long userId) {
		TwUser user = new TwUser();
		user.setId(userId);
		
		Tweet t = new Tweet();
		t.setTitle(title);
		t.setText(text);
		t.setUser(user);
		t.setPublishTime(new Date());
		Tweet result = tweetDao.save(t);
		
		return result;
	}

	@Override
	public void saveAuto() {
		for(int i = 0;i < 100;i++) {
			String title = TweetUtils.generateTitle();
			String text = TweetUtils.generteText();
			Tweet t = new Tweet();
			t.setTitle(title);
			t.setText(text);
			t.setPublishTime(new Date());
			TwUser user = new TwUser();
			if(i%2 == 0) {
				user.setId(1L);
				user.setName("u1");
				user.setPassword("123456");
				user.setSex(0);//Å®
			} else {
				user.setId(2L);
				user.setName("u2");
				user.setPassword("654321");
				user.setSex(1);//ÄÐ
			}
			t.setUser(user);
			tweetDao.save(t);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
