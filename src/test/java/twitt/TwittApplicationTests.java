package twitt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import twitt.service.TwittService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwittApplicationTests {
	
	@Autowired
	private TwittService twittService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAutoSave() {
		twittService.saveAuto();
	}
	
	public void test1() {
		System.out.println("aaa");
		System.out.println("bbb");
	}

}
