package soundsystem;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;

/**
 * 不加@component
 * 使用bean声明
 * @author Administrator
 *
 */
//@Component
//@Qualifier("guoge")
public class GuogeCD implements CompactDisc {
	private final String title = "义勇军进行曲";
	private final String artist = "Nie Er";
	
	@Override
	public String play() {
		return "Playing "+title+" by "+artist;
	}

}
