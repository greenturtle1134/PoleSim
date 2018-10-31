import javax.swing.JFrame;

public class PoleApp {

	public static void main(String[] args) {
		JFrame f1 = startSim(new PoleSim(1, 1200, 1200, 100, 0.25, 600, 400, 12, 0));
		JFrame f2 = startSim(new PoleSim(2, 1200, 1200, 100000, 0.25, 600, 400, 15, 0));
		JFrame f3 = startSim(new PoleSim(3, 1200, 1200, 10000000, 0.25, 600, 400, 15, 0));
		
		f1.setLocation(0,0);
		f2.setLocation(400,0);
		f3.setLocation(800,0);
		f1.setTitle("Linear gravity");
		f2.setTitle("Quadratic gravity");
		f3.setTitle("Cubic gravity");

	}
	
	public static JFrame startSim(PoleSim sim) {
		JFrame frame = new JFrame("POLE");
		frame.setSize(400, 400);
		frame.setContentPane(sim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Thread thread = new Thread(sim);
		thread.start();
		return frame;
	}

}
