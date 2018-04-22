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

public class View extends JFrame {
	JPanel jp = new JPanel();
	JLabel jl = new JLabel("ini pertanyaannyaaaa");
	JTextField jt = new JTextField("Enter your answer here...",30);
	JButton jb = new JButton("Enter");

	// convention: board[row][col]

	// values: 0 = not visited node
	// 		1 = wall
	// 		2 = visited node
	// 9 = target node

	//start at 1,1
	 private char[][] board=
	{ {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','#','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'}, 
	  {'#','.','.','.','.','.','.','.','.','.','.','.','.','#'},
	  {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}, 
	};


	 public View() {
	 		setTitle("Praktikum Dash!");
	 		setSize(520,600);
	 		setLocationRelativeTo(null);
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		//jt.setLocationRelativeTo()

	 		//======= Kasih Pertanyaan =====================

	 		jl.setText("ini diganti pertanyaannya");

	 		//======= BUAT INPUTAN DR KEYBOARD =============


	 		//this.setLayout(null);
	 		//jp.setLayout(null);
	 		jb.setBounds(300,500,100,200);
	 		jp.add(jt);
	 		jp.add(jb);
	 		jp.add(jl);
	 		jb.addActionListener(new ActionListener(){
 				public void actionPerformed(ActionEvent ae){
 					String input = jt.getText();
 					System.out.println("Input: "+input);
 				}
	 		});
	 		//jp.setBackground(Color.BLACK);
	 		add(jp);
	 		jb.setLocation(500,100);

	 		//=== end==

	 }

 	@Override
 	public void paint(Graphics g) {
 		//super.paint(g);
 		g.translate(50,50);

 		//gambar boardnya
 		for (int row=0; row<(board.length); row++) {
 			for (int col=0; col<(board[0].length); col++) {
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

 	public void setView (char[][] map){
 		this.board=map;
 	}
	 public static void main (String[] args){
	 	SwingUtilities.invokeLater(new Runnable() {

	 		@Override
	 		public void run() {
	 			View view = new View();
	 			view.setVisible(true);
	 			view.repaint();
	 				 		}
	 	});
	 } 
}