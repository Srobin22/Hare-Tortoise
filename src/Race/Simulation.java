package Race;
//SHAMIM BABUL
//PROJECT 2

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
public class Simulation implements Runnable {

	private Display display;
	private int width,height;
	private String title;
	private BufferStrategy buffer;
	private Graphics graphics;
	private boolean running = false;
	private Thread thread;
	private Hare hare;
	private Tortoise tortoise;
	private Race race;
	private boolean WinningMenu=false;
	private boolean start=false;
	private int time;
	private int track;
	boolean consoleWIN=false;
	public Simulation() {
		title="Hare vs Tortoise Race";
		width=1280;
		height=720;
		race=new Race();
		hare=new Hare();
		tortoise= new Tortoise();
	}
	public Simulation(String title,int width,int height, int track) {
		this.title=title;
		this.width=width;
		this.height=height;
		this.track=track;
		race=new Race(track);
		hare=new Hare(track);
		tortoise=new Tortoise(track);

	}
	private void generateDisplay() {
		display= new Display(title,width,height);
	}
	private void renderSim() {
		buffer=display.getCanvas().getBufferStrategy();
		if(buffer==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics=buffer.getDrawGraphics();
		graphics.clearRect(0,0,width,height);
		graphics.drawImage(race.getImage(),0,0,null);

		//Updates the Position on the canvas
		graphics.drawImage(hare.getImage(),hare.get_pos()*race.getMultiplier(),390,null);
		graphics.drawImage(tortoise.getImage(), tortoise.get_pos()*race.getMultiplier(), 430, null);
		//Shows the race started
		if(start==false) {
			graphics.setColor(Color.yellow);
			graphics.setFont(new Font("TimesRoman",Font.PLAIN,100));
			graphics.drawString("BANG !!!!", 100, 200);
			graphics.drawString("AND THEY'RE OFF !!!!!",100, 300);

		}
		//Shows OUCH if they are in the same position
		if(tortoise.get_pos()==hare.get_pos()&& start==true) {
			graphics.setColor(Color.red);
			graphics.setFont(new Font("TimesRoman",Font.PLAIN,100));
			graphics.drawString("OUCH", tortoise.get_pos()*race.getMultiplier(), 550);
		}
		//Shows the Positions
		graphics.setColor(Color.blue);
		graphics.setFont(new Font("TimesRoman",Font.PLAIN,60));
		graphics.drawString("Tortoise Position:", 0, 600);
		graphics.drawString(String.valueOf(tortoise.get_pos()),450,600);
		graphics.setColor(Color.yellow);
		graphics.drawString("Hare  Position:", 0, 680);
		graphics.drawString(String.valueOf(hare.get_pos()),450,680);


		//SHOWS TIME
		graphics.setColor(Color.black);
		graphics.setFont(new Font("TimesRoman",Font.PLAIN,60));
		graphics.drawString("Time:", 700, 600);
		graphics.drawString(String.valueOf(time),900,600);

		buffer.show();
		graphics.dispose();
	}
	private void RenderWin() {
		buffer=display.getCanvas().getBufferStrategy();
		if(buffer==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics=buffer.getDrawGraphics();
		graphics.clearRect(0,0,width,height);
		graphics.drawImage(race.getImage(),0,0,null);
		graphics.setColor(Color.red);
		graphics.setFont(new Font("TimesRoman",Font.PLAIN,150));
		if(hare.isWon()&&tortoise.isWon()) {
			graphics.drawString("It's A TIE!!!", 100, 200);

		}
		else if(tortoise.isWon()==true) {

			graphics.drawString("TORTOISE WINS!!", 10, 200);
			graphics.drawString("YAY!!!", 250, 400);

		}
		else if(hare.isWon()==true) {

			graphics.drawString("Hare WINS!!!", 10, 200);
			graphics.drawString("Yuch!!!", 250, 400);
		}
		graphics.setFont(new Font("TimesRoman",Font.PLAIN,100));

		graphics.drawString("TIME ELAPSED:",20,600);
		graphics.drawString(String.valueOf(time),800,600);
		buffer.show();
		graphics.dispose();


	}

private void update(){

		if(tortoise.isWon()==true||hare.isWon()==true) {
			WinningMenu=true;
		}
		else {
			hare.move();
			tortoise.move();
			time++;
		}

}
//delay inspired by https://stackoverflow.com/questions/38525268/game-loop-doesnt-work
public void delay(int mil){
    try{
        Thread.sleep(mil);
    }catch(Exception e){

    }
}
	public void run() {
		generateDisplay();



		 System.out.printf("BANG!!! THEY ARE OFF\n");


		time=0;

		while(running){
			//change the delay to lower number for faster simulation
			delay(1000);
			if(WinningMenu==false) {
			renderSim();
			}
				if(WinningMenu==false) {
				//for the console outputs; showing the same race
				for(int i=1; i<=track; i++) System.out.printf("-");
				System.out.printf("\n");
				for(int i=1;i<=hare.get_pos();i++)  System.out.printf(" ");

				printf("\n");
				if(hare.get_pos()==tortoise.get_pos() && start==true) System.out.printf("OUCH!!!\n");
				else {
					System.out.printf("H\n");


				for(int i=1;i<=tortoise.get_pos();i++)System.out.printf(" ");
				System.out.printf("T\n");
				}
				for(int i=1; i<=track; i++) System.out.printf("-");
				System.out.printf("\n");
				}
				if(WinningMenu==true && consoleWIN==false ) {
					if(hare.isWon()==true && tortoise.isWon()==true)System.out.printf("It's a Tie\n");
					if(hare.isWon()) {
						System.out.printf("Hare Won!!!\n Yutch");
					}
					else System.out.printf("Tortoise Won!!! \n YAY!!!");
					consoleWIN=true;
				}
				if(start==false) {
					renderSim();
					start=true;
				}

				if(WinningMenu==true) {
					RenderWin();

				}
				update();
				renderSim();

		}

		stop();

	}
	private void printf(String string) {
		// TODO Auto-generated method stub

	}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}
}
