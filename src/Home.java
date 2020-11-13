
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends JPanel{
    
    ImageIcon bg= new ImageIcon(this.getClass().getResource("water.jpg"));
    ImageIcon startBT= new ImageIcon(this.getClass().getResource("start.png"));
    ImageIcon fishhome= new ImageIcon(this.getClass().getResource("fishhome.png"));
    JButton start= new JButton(startBT);
    Home(){
        setBackground(Color.black);
        setLayout(null);
        add(start);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        start.setContentAreaFilled(false);
        start.setBounds(265, 300, 260, 260);
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, this);
        g.drawImage(fishhome.getImage(), 225, 20, this);
         
        
    }
    
    
    
    
}
