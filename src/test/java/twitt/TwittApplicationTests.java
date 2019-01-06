package twitt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import soundsystem.CompactDisc;
import twitt.service.ITweetService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwittApplicationTests {
	
	@Value("#{T(System).currentTimeMillis()}")
	private long currentTimeMills;
	
	@Value("#{3.66E8}")
	private int val;
	
	@Value("#{sgtPeggers.name}")
	private String name;
	
	@Value("#{sgtPeggers.play()?.toUpperCase()}")
	private String play;
	
	@Autowired
	private ITweetService twittService;

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
	
	@Test
	public void testSpEL() {
		System.out.println(currentTimeMills);
		System.out.println(val);
		System.out.println(name);
		System.out.println(play);
	}

}
