import javax.swing.JFrame;

public class PoleApp {

	public static void main(String[] args) {
		
		PoleSim sim = new PoleSim(1, 1200, 1200, 400, 0.2, 600, 300, 8, 0);
		JFrame frame = new JFrame("POLE");
		frame.setSize(1200, 1200);
		frame.setContentPane(sim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Thread thread = new Thread(sim);
		thread.start();

	}

}
