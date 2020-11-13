
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class harpoon extends JPanel{
        public ImageIcon imfire = new ImageIcon();
        public int y;
        public int x;
        public int count=0;
        harpoon(int x,int y){
           

                imfire = new ImageIcon(this.getClass().getResource("harpoon.png"));
          
                this.x=x;
                this.y=y;
        }

            public void move(){
        this.y+=1;
        }
        public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,20,20));
         }
    }