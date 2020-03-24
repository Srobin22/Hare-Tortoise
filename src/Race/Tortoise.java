package Race;
//SHAMIM BABUL
//PROJECT 2

import java.awt.image.BufferedImage;

public class Tortoise  {
	private int pos=1;
	private boolean won=false;
	private BufferedImage sprite;
	private int track_pos;

	public Tortoise(){
		pos=1;
		won=false;
		track_pos=70;
		sprite=Image.loadImage("/tortoise.png");
	}
	public Tortoise(int track_pos) {
		pos=1;
		won=false;
		this.track_pos=track_pos;
		sprite=Image.loadImage("/tortoise.png");
	}
	public BufferedImage getImage() {
		return sprite;
	}
	public int get_pos() {
		return pos;
	}
	private void set_pos(int tortoise_pos) {
		this.pos = tortoise_pos;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}

	private void fastFlood() {
		if(get_pos()<track_pos) {
			set_pos(get_pos()+3);
			if(get_pos()>track_pos) {
				set_pos(track_pos);
				setWon(true);
			}
			}
		else setWon(true);
	}
	private void slip() {
		if(get_pos()<=6) set_pos(1);
		else set_pos(get_pos()-6);
	}
	private void slowPod() {
		if(get_pos()<track_pos) {
			set_pos(get_pos()+1);
			if(get_pos()>track_pos) {
				set_pos(track_pos);
				setWon(true);
			}
		}
		else setWon(true);
	}

	public void move() {
		int i= (int) (1+Math.random()*10);

		if(i>=1 && i<=2) slip();
		if(i>=3 && i<=7) fastFlood();
		if(i>7) slowPod();
	}


	}
