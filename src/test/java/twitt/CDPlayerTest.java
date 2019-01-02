package twitt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;
import twitt.confiuration.SoundSystemConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class CDPlayerTest {
	
	@Autowired
	@Qualifier("sgt")
	private CompactDisc sgt;
	
	@Autowired
	@Qualifier("guoge")
	private CompactDisc guoge;
	
	@Autowired
	@Qualifier("cdPlayer")
	private MediaPlayer player;
	
	@Autowired
	@Qualifier("repeatPlayer")
	private MediaPlayer repeatPlayer;
	
	/**
	 * ��ǰ����ʵ��CompactDisc�ӿڵ�beanֻ��SgtPeggers
	 * ���Կ���ͨ������������ok
	 */
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(sgt);
	}
	
	@Test
	public void testPlay() {
		String result = player.playSgt();
		assertEquals("Playing Sgt. Pegger's Lonely Hearts Club Band by The Beatles",result);
		
		result = player.playGuoge();
		assertEquals("Playing ���¾������� by Nie Er",result);
	}
	
	@Test
	public void testRepeatPlayer() {
		String result = repeatPlayer.playGuoge();
		assertEquals("Playing ���¾������� by Nie Er",result);
		
		result = player.playSgt();
		assertEquals("Playing Sgt. Pegger's Lonely Hearts Club Band by The Beatles",result);
	}
}
