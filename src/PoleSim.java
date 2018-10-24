import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PoleSim extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double exponent, width, height, G, step;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private BufferedImage image;
	
	public PoleSim(double exponent, double width, double height, double G, double step, double x, double y, double dx, double dy) {
		this.exponent = exponent;
		this.width = width;
		this.height = height;
		this.G = G;
		this.step = step;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.image = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = this.image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (int) width, (int) height); 
		g.setColor(Color.WHITE);
		g.fillOval((int) width/2-5, (int) height/2-5, 10, 10);
	}

	@Override
	public void run() {
		while(true) {
			this.doTick();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void doTick() {
		double distance = Math.sqrt(Math.pow(x-width/2, 2)+Math.pow(y-height/2, 2));
		double acceleration = G/Math.pow(distance, exponent);
		acceleration*=step;
		dx+=acceleration*(width/2-x)/distance;
		dy+=acceleration*(height/2-y)/distance;
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.drawLine((int) x, (int) y, (int) (dx*step+x), (int) (dy*step+y));
		x+=dx*step;
		y+=dy*step;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		g.drawLine(0, (int) (y*this.getHeight()/height), this.getWidth(), (int) (y*this.getHeight()/height));
		g.drawLine((int) (x*this.getWidth()/width), 0, (int) (x*this.getWidth()/width), this.getHeight());
	}

}
