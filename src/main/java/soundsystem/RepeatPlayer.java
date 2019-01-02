package soundsystem;


public class RepeatPlayer implements MediaPlayer {

	private CompactDisc sgt;
	
	private CompactDisc guoge;
	
	@Override
	public String playSgt() {
		return sgt.play();
	}

	@Override
	public String playGuoge() {
		return guoge.play();
	}

	public CompactDisc getSgt() {
		return sgt;
	}

	public void setSgt(CompactDisc sgt) {
		this.sgt = sgt;
	}

	public CompactDisc getGuoge() {
		return guoge;
	}

	public void setGuoge(CompactDisc guoge) {
		this.guoge = guoge;
	}

}
