package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cdPlayer")
public class CDPlayer implements MediaPlayer {

	@Autowired
	@Qualifier("sgt")
	private CompactDisc sgt;
	
	@Autowired
	@Qualifier("guoge")
	private CompactDisc guoge;

	@Override
	public String playSgt() {
		return sgt.play();
	}

	@Override
	public String playGuoge() {
		return guoge.play();
	}
	
}
