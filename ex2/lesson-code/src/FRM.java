// import java.awt.*;
// import java.awt.event.*;

// public class FRM extends Frame {
//     public FRM(){
//         super("Example: Frame and Canvas");
//         add(new CVS()); // add a canvas to paint
//         setSize(400,200);
//     }
//     public static void main(String[] args){
//         // Frame.setVisible(true)でフレームオブジェクトを表示できる。
//         new FRM().setVisible(true);
//     }
//     class CVS extends Canvas {
//     // paint this canvas
//         public void paint(final Graphics g){
//             g.drawRect(50,25,300,100);
//             g.drawString("FRM is-a container",60,50);
//             g.drawString("CVS is-not-a container",60,80);
//         }
//     }
// }
