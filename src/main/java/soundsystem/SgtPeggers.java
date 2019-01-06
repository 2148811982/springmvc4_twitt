package soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sgt")
public class SgtPeggers implements CompactDisc {

	private final String title = "Sgt. Pegger's Lonely Hearts Club Band";
	private final String artist = "The Beatles";
	
	public String name = "my name";
	
	@Override
	public String play() {
		return "Playing "+title+" by "+artist;
	}

}
