package twitt;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import conditional.MagicBean;
import twitt.confiuration.SoundSystemConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class ConditionalTest {

	@Autowired
	private MagicBean magicBean;
	
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(magicBean);
	}
}
