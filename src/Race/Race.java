package Race;
//SHAMIM BABUL
//PROJECT 2

import java.awt.image.BufferedImage;

public  class Race {
	private BufferedImage sprite;
    protected int track;
    private int multiplier;

    Race(){
    	track=70;
    	multiplier=1250/track;
    	sprite=Image.loadImage("/racing_track.png");
    }
    Race(int track_pos){
    	track=track_pos;
    	multiplier=1150/track;
    	sprite=Image.loadImage("/racing_track.png");
    }
    public int getT() {
    	return track;
    }

	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track=track;
	}


	public BufferedImage getImage() {
		return sprite;
	}
	public int getMultiplier() {
		return multiplier;
	}


}
