package twitt.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitt.dao.TwittDao;
import twitt.domain.Twitt;
import utils.TwittUtils;

@Service
public class TwittServiceImpl implements TwittService {
	
	@Autowired
	private TwittDao twittDao;

	@Override
	public List<Twitt> findAll() {
		List<Twitt> twitts = twittDao.findAll();
		return twitts;
	}

	@Override
	public Twitt findByTitle(String title) {
		Twitt twitt = twittDao.findByTitle(title);
		return twitt;
	}

	@Override
	public List<Twitt> queryAfter(String timeStr) throws ParseException {
		DateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date time = f.parse(timeStr);
		List<Twitt> twitts = twittDao.queryAfter(time);
		return twitts;
	}

	@Override
	public Twitt save(String title, String text) {
		Twitt t = new Twitt();
		t.setTitle(title);
		t.setText(text);
		t.setPublishTime(new Date());
		Twitt result = twittDao.save(t);
		
		return result;
	}

	@Override
	public void saveAuto() {
		for(int i = 0;i < 100;i++) {
			String title = TwittUtils.generateTitle();
			String text = TwittUtils.generteText();
			Twitt t = new Twitt();
			t.setTitle(title);
			t.setText(text);
			t.setPublishTime(new Date());
			twittDao.save(t);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
