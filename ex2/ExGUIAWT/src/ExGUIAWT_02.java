import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;


/**
* @author Shingo
*/

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener{

    protected Button IncButton;
    protected Button DecButton;
    protected Panel panel;



    public ExGUIAWT_02(String title){
        super(title);
        IncButton = new Button("Increase r(r <= 100)");
        IncButton.addActionListener(this);
        DecButton = new Button("Decrease r(r >= 100)");
        DecButton.addActionListener(this);
        
        panel = new Panel();
        panel.add(IncButton);
        panel.add(DecButton);
        this.add(panel, BorderLayout.SOUTH);
    
    }

    public void actionPerformed(ActionEvent e){
        
        if (e.getSource().equals(IncButton)){
            if(this.r <100) this.r++;
            System.out.println(String.format("Increment! %d" , this.r));
            cvs.repaint();
        }
        else if(e.getSource().equals(DecButton)){
            if(this.r > 0) this.r--;
            System.out.println(String.format("Decrement! %d" , this.r));

            cvs.repaint();
        }
    }


    public static void main(String[] args){

        new ExGUIAWT_02("Ex#1: Step 2").setVisible(true);

    }

}

