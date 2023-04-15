import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;


/**
* @author Shingo
*/

public class ExGUIAWT_01 extends Frame{
    protected Point center = new Point(200,100);
    protected int r = 100;

    protected final ExGUIAWT_CVS cvs = new ExGUIAWT_CVS();  

    public ExGUIAWT_01(String title){
        super(title);
        System.out.println("Default layout manager of Frame: " + getLayout());
        setSize(400,300);
        add(cvs);  // add canvas to paint with BorderLayout.CENTER

    }

    protected final class ExGUIAWT_CVS extends Canvas{ // extends Canvas
        // paint this canvas
        @Override  
        public void paint(final Graphics g){
            g.clearRect(0, 0, 400, 200);
            g.setColor(Color.blue);
            g.drawRect(10, 0, 400 - 20, 200);
            g.setColor(Color.red);
            g.drawOval(center.x - r, center.y - r,2*r,2*r);
            g.setColor(Color.black);
            g.drawString("The circle:",140,90);
            g.drawString(String.format("center = (%d,%d);", center.x, center.y), 160,110);
            g.drawString("radius = " + r,160,130);  // 現時点ではgetter を使わずにr 、centerにアクセスしてる。
        }
    }



    public static void main(String[] args){

        new ExGUIAWT_01("Ex#1: Step 1").setVisible(true);

    }

}

