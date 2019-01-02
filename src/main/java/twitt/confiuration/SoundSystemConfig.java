package twitt.confiuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import soundsystem.CompactDisc;
import soundsystem.GuogeCD;
import soundsystem.MediaPlayer;
import soundsystem.RepeatPlayer;
import soundsystem.SgtPeggers;
import soundsystem.SoundSystemScanMarker;

@Configuration
//@ComponentScan(value = {"soundsystem"})
@ComponentScan(basePackageClasses = SoundSystemScanMarker.class)
public class SoundSystemConfig {

	/**
	 * bean name默认为方法名
	 * GuogeCD bean为CompactDisc接口实现之一，必须是特殊bean name，否则spring会报多个bean歧义
	 * @return
	 */
	@Bean(/*"guoge"*/)
	public CompactDisc guoge() {
		return new GuogeCD();
	}
	
	/**
	 * 如果用这种方式实例化repeatPlayer bean，必须在RepeatPlayer类中使用构造器注入，否则无法注入guoge bean产生空指针
	 * @return
	 */
	@Bean
	public MediaPlayer repeatPlayer(GuogeCD guoge, SgtPeggers sgt) {
		RepeatPlayer player = new RepeatPlayer();
		player.setGuoge(guoge);
		player.setSgt(sgt);
		return player;
	}
}
