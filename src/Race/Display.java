package Race;
//SHAMIM BABUL
//PROJECT 2
//See Chiu

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
//DISPLAY CLASS: will create new display using the JFrame, and a canvas to draw on.
public class Display {
	private JFrame frame;
	private Canvas canvas;
	private int w,h;
	private String title;
	public Display(String title,int w,int h) {
		this.title=title;
		this.w=w;
		this.h=h;
		generateDisplay();
	}
	//creates a frame using the size and the title provided. then creates a canvas to draw on.
	private void generateDisplay() {
		frame=new JFrame(title);
		frame.setSize(w,h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(w, h));
		canvas.setMaximumSize(new Dimension(w, h));
		canvas.setMinimumSize(new Dimension(w, h));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
