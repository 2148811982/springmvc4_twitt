package soundsystem;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;

/**
 * ����@component
 * ʹ��bean����
 * @author Administrator
 *
 */
//@Component
//@Qualifier("guoge")
public class GuogeCD implements CompactDisc {
	private final String title = "���¾�������";
	private final String artist = "Nie Er";
	
	@Override
	public String play() {
		return "Playing "+title+" by "+artist;
	}

}
