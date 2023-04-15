import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;



/**
* @author Shingo
*/

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener{

    public ExGUIAWT_03(String title){
        super(title);
        cvs.addMouseListener(this);
    
    }

    public void mouseClicked(MouseEvent e){
        this.center.x = e.getX();
        this.center.y = e.getY();
        System.out.println(center);
        this.cvs.repaint();

    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }

    public static void main(String[] args){

        new ExGUIAWT_03("Ex#1: Step 3").setVisible(true);

    }

}

