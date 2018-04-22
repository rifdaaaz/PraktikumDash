import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class View extends JFrame implements ActionListener {
	JPanel jp = new JPanel();
	JLabel jl = new JLabel("ini pertanyaannyaaaa");
	JTextField jt = new JTextField("Enter your answer here...",30);
	JButton jb = new JButton("Enter");
	public static String inputtoShare;
	public static boolean isChanged = false;
	//ImageIcon icon = new ImageIcon("0.jpg","kak raudy");

	// convention: board[row][col]

	// values: 0 = not visited node
	// 		1 = wall
	// 		2 = visited node
	// 9 = target node

	//start at 1,1
	private char[][] board = 
		{ 	{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

	public static void toggleChange() {
		isChanged = isChanged ? false : true;
	}

	public static boolean getAnswerStatus() {
		return isChanged;
	}

	public static synchronized String getInput() {
		return inputtoShare;
	}

	public View() {
	 		setTitle("Praktikum Dash!");
	 		setSize(520,600);
	 		setLocationRelativeTo(null);
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	 		//jt.setLocationRelativeTo()

	 		//======= Kasih Pertanyaan =====================

	 		jl.setText("Siapa laki-laki paling ganteng di STI 2016?");

	 		//======= BUAT INPUTAN DR KEYBOARD =============


	 		jp.setLayout(null);

			// Lokasi Button
			jp.add(jb);
	 		jb.setBounds(250, 500, 100, 20);


	 		// Set pertanyaan
	 		jp.add(jl);
			jl.setLocation(40,430);
			jl.setSize(500,80);

			// Set jawaban
			jp.add(jt);
			jt.setLocation(40,500);
			jt.setSize(200,20);

			jp.add(jb);
			jt.setLocation(40,500);
			jt.setSize(200,20);

	 		jb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					String input = jt.getText();
					System.out.println(input);
					inputtoShare = input;
					toggleChange();
				}
			});
	 		//jp.setBackground(Color.BLACK);
	 		add(jp);


	 		//=== end==

	 }
	
	public void setView (char[][] map) {
		this.board = map;
	}
	 public void actionPerformed(ActionEvent arg0) {
		Peta p = Peta.getInstance();
		setView(p.get());
		repaint();
	 }
 	@Override
 	public void paint(Graphics g) {
 		super.paint(g);
 		g.translate(50,50);

 		//gambar boardnya
 		for (int row=0; row<(board.length); row++) {
 			for (int col=0; col<(board.length); col++) {
 				Color color;
 				switch (board[row][col]) {
 					case '#': color = Color.BLACK; break;
 					case '.': color = Color.WHITE; break;
 					case '1': color = Color.RED; break;
 					case 'A': color = Color.GREEN; break;
 					case 'B': color = Color.BLUE; break;
 					default : color = Color.RED;
 				}
 				g.setColor(color);
 				g.fillRect(30*col,30*row,30,30);
 				g.setColor(Color.BLACK);
 				g.drawRect(30*col,30*row,30,30);

 			}
 		}
 	}

 	
	//  public static void main (String[] args){
	//  	SwingUtilities.invokeLater(new Runnable() {

	//  		@Override
	//  		public void run() {
	//  			View view = new View();
	//  			view.setVisible(true);
	//  			view.repaint();
	//  		}
	//  	});
	//  } 
}