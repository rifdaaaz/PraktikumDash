import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
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
	public static State state=State.MENU;
	JPanel jp = new JPanel();
	JLabel jprak = new JLabel("Praktikan");
	JLabel jasis = new JLabel("Asisten");
	JLabel jlp[] = new JLabel[4];
	JLabel jla[] = new JLabel[2];
	JTextField jt = new JTextField("Enter your answer here...",30);
	JButton jb = new JButton("Enter");
<<<<<<< HEAD
	private static String inputtoShare;
	private static boolean isChanged = false;
	private static boolean changed = false;
	private static boolean statesChanged = false;
	private static String question;
=======
	private JPanel btn_close;
	private JLabel close = new JLabel("X");
	Font font = new Font("Lato", Font.ITALIC,14);
	Font fontb = new Font("Lato", Font.BOLD,16);

	private static String[] quotationPraktikan = new String[4];
	private static String[] quotationAsisten = new String[2];
	public static String inputtoShare;
	public static boolean isChanged = false;
>>>>>>> b0ebc6d1cafa572e5ed0f890420df524a9c88086
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

	public static void toggleStates(){
		statesChanged = statesChanged ? false : true;
	}
	public static void toggleGanti(){
		changed = changed ? false : true;
	}
	public static void toggleChange() {
		isChanged = isChanged ? false : true;
	}

	public static boolean getStatesStatus(){
		return statesChanged;
	}

	public static boolean getQuestionStatus(){
		return changed;
	}
	public static boolean getAnswerStatus() {
		return isChanged;
	}

	public static synchronized String getInput() {
		return inputtoShare;
	}

	public static void setQuestion(String question1){
		question = question1;
		toggleGanti();
	}

	public static String getQuestion(){
		toggleGanti();
		return question;
	}
	// public View() {
	//  		setTitle("Praktikum Dash!");
	//  		setSize(520,600);
	//  		setLocationRelativeTo(null);
	//  		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	//  		//jt.setLocationRelativeTo()

	//  		//======= Kasih Pertanyaan =====================


	// 		 jl.setText("Pertanyaan : " +question);
	// 		 if (question == null || !changed){
	// 			 jl.setText("Pertanyaan : " + question);
	// 		 }

	//  		//======= BUAT INPUTAN DR KEYBOARD =============


	//  		jp.setLayout(null);

	// 		// Lokasi Button
	// 		jp.add(jb);
	//  		jb.setBounds(250, 500, 100, 20);


	//  		// Set pertanyaan
	//  		jp.add(jl);
	// 		jl.setLocation(40,430);
	// 		jl.setSize(500,80);

	// 		// Set jawaban
	// 		jp.add(jt);
	// 		jt.setLocation(40,500);
	// 		jt.setSize(200,20);

	// 		// jp.add(button);
	// 		// jt.setLocation(40,500);
	// 		// jt.setSize(200,20);

	//  		jb.addActionListener(new ActionListener() {
	// 			public void actionPerformed(ActionEvent ae) {
	// 				String input = jt.getText();
	// 				System.out.println(input);
	// 				inputtoShare = input;
	// 				toggleChange();
	// 			}
	// 		});
	//  		//jp.setBackground(Color.BLACK);
	//  		add(jp);


	//  		//=== end==

	//  }
	public View() {
<<<<<<< HEAD
		setSize(520, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setView (char[][] map) {
		this.board = map;
	}
	 public void actionPerformed(ActionEvent arg0) {
		Peta p = Peta.getInstance();
		setView(p.get());
		repaint();
	 }

	 public void menu(Graphics g) {
		Rectangle playButton = new Rectangle(210, 250, 100, 50);
		Rectangle helpButton = new Rectangle(210, 350, 100, 50);
		Rectangle creditButton = new Rectangle(210, 450, 100, 50);
		Graphics2D g2d = (Graphics2D) g;

		try {
			BufferedImage logo = ImageIO.read(new File("fixlogo3.png"));
			g.drawImage(logo, 165, 50, this);
		} catch (IOException e) {
			System.out.println("Gambar tidak ada!");
		}

		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(creditButton);

		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Play", playButton.x + 30, playButton.y + 32);
		g.drawString("Help", helpButton.x + 30, helpButton.y + 32);
		g.drawString("Credit", creditButton.x + 24, creditButton.y + 32);

	}
	public void game(Graphics g) {
			setTitle("Praktikum Dash!");
=======
	 		setTitle("Praktikum Dash!");
	 		setSize(900,600);
	 		setLocationRelativeTo(null);
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		setUndecorated(true);
			setResizable(false);
			//jp.setBackground(new java.awt.Color(51, 51, 51));

>>>>>>> b0ebc6d1cafa572e5ed0f890420df524a9c88086
			
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
				jlp[i].setFont(font);
	 		}
	 		// Set label asisten
	 		for (int i = 0; i<2; i++) {
		 		jp.add(jla[i]);
				jla[i].setLocation(500,80+15*i);
				jla[i].setSize(500,15);
				jla[i].setFont(font);
	 		}

			// Set jawaban
			jp.add(jt);
			jt.setLocation(500,400);
			jt.setSize(200,20);

			jp.add(jprak);
			jprak.setLocation(500,130);
			jprak.setSize(500,15);
			jprak.setFont(fontb);

			jp.add(jasis);
			jasis.setFont(fontb);
			jasis.setLocation(500,60);
			jasis.setSize(500,15);


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
<<<<<<< HEAD
 	// @Override
 	// public void paint(Graphics g) {
 	// 	super.paint(g);
 	// 	g.translate(50,50);

 	// 	//gambar boardnya
 	// 	for (int row=0; row<(board.length); row++) {
 	// 		for (int col=0; col<(board.length); col++) {
 	// 			Color color;
 	// 			switch (board[row][col]) {
 	// 				case '#': color = Color.BLACK; break;
 	// 				case '.': color = Color.WHITE; break;
 	// 				case '1': color = Color.RED; break;
 	// 				case 'A': color = Color.GREEN; break;
 	// 				case 'B': color = Color.BLUE; break;
 	// 				default : color = Color.RED;
 	// 			}
 	// 			g.setColor(color);
 	// 			g.fillRect(30*col,30*row,30,30);
 	// 			g.setColor(Color.BLACK);
 	// 			g.drawRect(30*col,30*row,30,30);

 	// 		}
 	// 	}
 	// }

	 @Override
 	public void paint(Graphics g) {
		this.addMouseListener(new MouseInput());
		toggleStates();
		if (state == State.GAME) {
			super.paint(g);
			game(g);
			g.translate(50,50);
			
=======
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
>>>>>>> b0ebc6d1cafa572e5ed0f890420df524a9c88086

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
		else {
			super.paint(g);
			menu(g);
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