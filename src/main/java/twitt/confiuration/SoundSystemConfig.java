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
	 * bean nameĬ��Ϊ������
	 * GuogeCD beanΪCompactDisc�ӿ�ʵ��֮һ������������bean name������spring�ᱨ���bean����
	 * @return
	 */
	@Bean(/*"guoge"*/)
	public CompactDisc guoge() {
		return new GuogeCD();
	}
	
	/**
	 * ��������ַ�ʽʵ����repeatPlayer bean��������RepeatPlayer����ʹ�ù�����ע�룬�����޷�ע��guoge bean������ָ��
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
