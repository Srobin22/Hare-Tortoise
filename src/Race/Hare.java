package Race;
//SHAMIM BABUL
//PROJECT 2
import java.awt.image.BufferedImage;


public class Hare   {
	private int pos;
	private boolean won;
	private static BufferedImage sprite;
	private int track_pos;

	public Hare(){
		pos=1;
		won=false;
		track_pos=70;
		sprite=Image.loadImage("/hare.png");

	}
	public Hare(int track_pos){
		pos=1;
		won=false;
		this.track_pos=track_pos;
		sprite=Image.loadImage("/hare.png");
	}

	public BufferedImage getImage() {
		return sprite;
	}
	public int get_pos() {
		return pos;
	}
	public void set_pos(int hare_pos) {
		this.pos = hare_pos;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
	public void sleep() {
		set_pos(get_pos());
	}
	public void bigHop() {
		if(get_pos()<track_pos) {
			set_pos(get_pos()+9);
			if(get_pos()>track_pos) {
				set_pos(track_pos);
				setWon(true);
			}
		}
		else setWon(true);

	}
	public void bigSlip() {
		if(get_pos()<=12) set_pos(1);
		else set_pos(get_pos()-12);
	}
	public void smallHop() {
		if(get_pos()<track_pos) {
			set_pos(get_pos()+1);
			if(get_pos()>track_pos) {
				set_pos(track_pos);
				setWon(true);
			}
		}
		else setWon(true);

	}
	public void smallSlip() {
		if(get_pos()<=2) set_pos(1);
		else set_pos(get_pos()-2);
	}
	public void move() {
		int i= (int) (1+Math.random()*10);

		if(i<=2) sleep();
		if(i>=3 && i<=4) bigHop();
		if(i==5) bigSlip();
		if(i>=6 && i<=8) smallHop();
		if(i>8) smallSlip();
	}
}
