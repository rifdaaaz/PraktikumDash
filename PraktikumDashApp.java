import javax.swing.*;

public class PraktikumDashApp {
	

	public static void main( String[] args){

		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new JFrame("Praktikum Dash!");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,400);
				frame.setVisible(true);
			}
		});

 
	}
}