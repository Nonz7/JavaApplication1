import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class startup extends JFrame implements ActionListener{
    Home home=new Home();
    playstate p=new playstate();
    playstate2 state2=new playstate2();
    startup(){
        add(home);
        home.start.addActionListener(this);
        p.Bnext.addActionListener(this);
        state2.BExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home.start){
            System.out.println("startup.actionPerformed()");
            this.remove(home);
            this.add(p);
            p.times=30;
            p.timestart=false;
            p.requestFocusInWindow();
        }
        else if(e.getSource()==p.Bnext){
            remove(p);
            add(state2);
            state2.requestFocusInWindow();
		state2.timestart = true;
		state2.scor=0;
		state2.times = 50;
		state2.frequency=false;
		state2.timestart=false;
        }
        else if(e.getSource()==state2.BExit){
            System.exit(0);
        }
        validate();
        repaint();
    }

    
}
