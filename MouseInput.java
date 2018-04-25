import java.awt.*;
import java.awt.event.*;

public class MouseInput implements MouseListener {

    /* public MouseInput() {
        addMouseListener(this);
    } */

    public void mousePressed(MouseEvent e) {

        double mx = e.getX();
        double my = e.getY();
        /*  Rectangle playButton = new Rectangle(210, 250, 100, 50);
		    Rectangle helpButton = new Rectangle(210, 350, 100, 50);
		    Rectangle creditButton = new Rectangle(210, 450, 100, 50); */
        if (mx >= 210 && mx <= 310) {
            if (my >= 250 && my <= 300) {
                View.state = State.GAME;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}