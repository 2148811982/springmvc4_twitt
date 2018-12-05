package twitt.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitt.dao.TweetDao;
import twitt.domain.TwUser;
import twitt.domain.Tweet;
import utils.TweetUtils;

@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	private TweetDao twittDao;

	@Override
	public List<Tweet> findAll() {
		List<Tweet> twitts = twittDao.findAll();
		return twitts;
	}

	@Override
	public List<Tweet> findByTitle(String title) {
		List<Tweet> twitts = twittDao.findByTitle(title);
		return twitts;
	}

	@Override
	public List<Tweet> queryAfter(String timeStr) throws ParseException {
		DateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date time = f.parse(timeStr);
		List<Tweet> twitts = twittDao.queryAfter(time);
		return twitts;
	}

	@Override
	public Tweet save(String title, String text) {
		Tweet t = new Tweet();
		t.setTitle(title);
		t.setText(text);
		t.setPublishTime(new Date());
		Tweet result = twittDao.save(t);
		
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
			twittDao.save(t);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
