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
	// JLabel jprak = new JLabel("Praktikan");
	// JLabel jasis = new JLabel("Asisten");
	JLabel jlp[] = new JLabel[4];
	JLabel jla[] = new JLabel[2];
	JTextField jt = new JTextField("Enter your answer here...",30);
	JButton jb = new JButton("Enter");
	private JPanel btn_close;
	private JLabel close = new JLabel("X");

	private static String[] quotationPraktikan = new String[4];
	private static String[] quotationAsisten = new String[2];
	public static String inputtoShare;
	public static boolean isChanged = false;
	//ImageIcon icon = new ImageIcon("0.jpg","kak raudy");

	// convention: board[row][col]

	// values: 0 = not visited node
	// 		1 = wall
	// 		2 = visited node
	// 9 = target node

	//start at 1,1

	private void closeMouseClicked(java.awt.event.MouseEvent evt) {                                   
        System.exit(0);        // TODO add your handling code here:
    }   

	private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.exit(0);        // TODO add your handling code here:
    }  

	public static void setQuotationPraktikan(String q, int i){
		quotationPraktikan[i] = q;
	}
	public static void setQuotationAsisten(String q, int i){
		quotationAsisten[i] = q;
	}

	private char[][] board = 
		{ 	{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
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
	 		setSize(900,600);
	 		setLocationRelativeTo(null);
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		setUndecorated(true);
			setResizable(false);
			//jp.setBackground(new java.awt.Color(51, 51, 51));

			
	 		//jt.setLocationRelativeTo()

	 		//======= Label Praktikan =====================
	 		for (int i = 0; i<4; i++) {
		 		quotationPraktikan[i] = "";
		 		jlp[i] = new JLabel(quotationPraktikan[i]);
	 		}
	 		for (int i = 0; i<2; i++) {
		 		quotationAsisten[i] = "";
		 		jla[i] = new JLabel(quotationAsisten[i]);
	 		}

	 		//======= BUAT INPUTAN DR KEYBOARD =============


	 		jp.setLayout(null);

			// Lokasi Button
			jp.add(jb);
	 		jb.setBounds(720, 400, 100, 20);


	 		// Set label praktikan
	 		for (int i = 0; i<4; i++) {
		 		jp.add(jlp[i]);
				jlp[i].setLocation(500,150+15*i);
				jlp[i].setSize(500,15);
	 		}
	 		// Set label asisten
	 		for (int i = 0; i<2; i++) {
		 		jp.add(jla[i]);
				jla[i].setLocation(500,80+15*i);
				jla[i].setSize(500,15);
	 		}

			// Set jawaban
			jp.add(jt);
			jt.setLocation(500,400);
			jt.setSize(200,20);

			// jp.add(button);
			// jt.setLocation(40,500);
			// jt.setSize(200,20);

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
 		for (int i = 0; i<4; i++) {
	 		jlp[i].setText(quotationPraktikan[i]);
 		}
 		for (int i = 0; i<2; i++) {
	 		jla[i].setText(quotationAsisten[i]);
 		}
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

 	
	 // public static void main (String[] args){
	 // 	SwingUtilities.invokeLater(new Runnable() {

	 // 		@Override
	 // 		public void run() {
	 // 			View view = new View();
	 // 			view.setVisible(true);
	 // 			view.repaint();
	 // 		}
	 // 	});
	 // } 
}