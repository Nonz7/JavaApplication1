
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Titanic{
    Image imgg;
    public int x=10,y=20;
    public int count = 0;
    Titanic(){
        String imageLocation = "titanic2.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        imgg = Toolkit.getDefaultToolkit().getImage(imageURL);
    }
    
        public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}