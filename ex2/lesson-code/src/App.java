import java.applet.*;
import java.awt.*;
import java.awt.event.*; 
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}


class MLF extends Frame implements MouseListener {
    MLF(){
        super("Example: MouseListener");
        addMouseListener(this);  // 
        setSize(250,100);
    }
    public void mouseClicked(MouseEvent me) {
        System.out.println("Clicked!");

    }
    public void mouseEntered(MouseEvent me) {
        // System.out.println(me);
        System.out.println("Entered!");

    }
    public void mouseExited(MouseEvent me) {
    }
    public void mousePressed(MouseEvent me) {
        // System.out.println("-------------------------------------------------------");
        // System.out.println(me);
        System.out.println("Pressed!");


    }
    public void mouseReleased(MouseEvent me) {
        // System.out.println(me);
        System.out.println("Released!");

    }
    public static void main(String[] args) {
        new MLF().setVisible(true);
    }
}



// class CanvasTest extends Frame {
//     public static void main(String[] args) {
//         new CanvasTest().setVisible(true);
        
//     }

//     CanvasTest() {
//         super("CanvasTest");
//         setSize(200, 100);
//         setLayout(new BorderLayout());
//         MyCanvas mc1 = new MyCanvas();
//         add(mc1, BorderLayout.CENTER);
//     }

//     class MyCanvas extends Canvas {
//         public void paint(Graphics g) {
//             g.drawline(10, 10, 120, 40);
//         }
//     }
// }

class FRM extends Frame {
    public FRM(){
        super("Example: Frame and Canvas");
        add(new CVS()); // add a canvas to paint
        setSize(400,200);
    }
    public static void main(String[] args){
        new FRM().setVisible(true);
    }
    class CVS extends Canvas {
    // paint this canvas
        @Override
        public void paint(final Graphics g){
            g.setColor(java.awt.Color.blue);
            // g.drawRect(50,25,400,300);
            // g.setColor(java.awt.Color.red);
            // g.drawRect(100,100, 200, 200);
            
            // g.drawString("FRM is-a container",60,50);
            // g.drawString("CVS is-not-a container",60,80);

            g.drawOval(100, 100, 200, 200);
        }
    }
}
