

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class state1 extends JPanel implements ActionListener{
    
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("level_background_for_a_mobile_game__by_bvigec-d5vi8b0.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("background_for_flash_game_by_pykodelbi-d4ly9hx.jpg"));
	private final ImageIcon imgmeleon = new ImageIcon(this.getClass().getResource("meleon.png"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("puse.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("resum.png"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("a_cartoon_forest_election_by_88srenaissance88-d4zim5f.jpg"));
	ImageIcon img_paralyze = new ImageIcon(this.getClass().getResource("7.1.png"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("exit.jpg"));
        ImageIcon bgff= new ImageIcon(this.getClass().getResource("fish2.jpg"));
	public ArrayList<fishfish> fish = new ArrayList<fishfish>();
	public ArrayList<fishfishfish> fishh = new ArrayList<fishfishfish>();
	private JLabel score = new JLabel(); 

        
        public Titanic tn2=new Titanic();
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startball = false;

	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
	
	Thread time = new Thread(new Runnable(){
            @Override
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
        Thread fish1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                        try{
                            if(startball == false){
                                Thread.sleep(5000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(startball == false){
                            fish.add(new fishfish());
                        }
                }
            }
        });
        Thread fish2 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                        try{
                            if(startball==false){
                                Thread.sleep(3000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(startball == false){
                            fishh.add(new fishfishfish());
                        }
                }
            }
        });
	
	state1(){
		this.setFocusable(true);
		this.setLayout(null);
		
		this.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			if(!paralyze1){
			    if(a==KeyEvent.VK_A){
			     	tn2.x-=100;
                                System.out.println("x+");
                            }
                            else if(a == KeyEvent.VK_D){
                               tn2.x+=100;
                               System.out.println("x-");
 
                            }
                            else if(a == KeyEvent.VK_UP){
                              
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
                       
		    }
		});
		
		fish1.start();
		fish2.start();
		time.start();
//		t.start();
//		tballs1.start();
//		tballs2.start();
//		tballs5.start();
//		paralyze.start();
	}
	
	
	
        @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bgff.getImage(), 0, 0, 800, 600, this);
		for(int i=0 ; i<fish.size();i++){
                    g.drawImage( fish.get(i).getImage() ,fish.get(i).getX(),fish.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fishh.size();i++){
                    g.drawImage( fishh.get(i).getImage() ,fishh.get(i).getX(),fishh.get(i).getY(),300,300,this);
		}
		/*for(int i=0 ; i<tn.size();i++){
                    g.drawImage( tn.get(i).getImage() ,tn.get(i).getX(),tn.get(i).getY(),300,300,this);
		} */              
                g.drawImage(tn2.imgg,tn2.x,0, this);

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
        @Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

