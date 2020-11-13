
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;


public class fishfishfish extends fishfish {
     Image img;
     	public int x = 800;
	public int y= (int) ((Math.random()*100)+170);
	public int count = 0;
    fishfishfish(){
        String imageLocation = "fish11.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
	public void run() {
            while(true){
		x -= 1;
		if(x >= 1100){
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try{
                    runner.sleep(10);
                }catch(InterruptedException e){}
            }
	}
    });

     @Override
    public Image getImage(){
	return img;
    }	
     @Override
	public int getX(){
            return x;
	}
     @Override
	public int getY(){
            return y;
	}
     @Override
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
    

