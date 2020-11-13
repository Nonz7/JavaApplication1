

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

public class playstate extends JPanel implements ActionListener{
	

	ImageIcon feildover = new ImageIcon(this.getClass().getResource("fish2.jpg"));
        
        public ArrayList<harpoon> harpoon = new ArrayList<>();
	public ArrayList<fishfish> fish = new ArrayList<>();
	public ArrayList<fishfishfish> fishh = new ArrayList<>();
        
	private JLabel score = new JLabel(); 
        public JButton Bnext  = new JButton("NEXT");
        
        ImageIcon bgff= new ImageIcon(this.getClass().getResource("fish2.jpg"));
        Titanic tn=new Titanic();
        
	public int times=5;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean fishmv = false;
	
       
	public int scor = 0;
	boolean peo = false;
	int timepeo=5;
	
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
	
	Thread actor = new Thread(new Runnable(){
            @Override
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
        Thread fish1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                        try{
                            if(fishmv == false){
                                Thread.sleep(5000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(fishmv == false){
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
                            if(fishmv==false){
                                Thread.sleep(7000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(fishmv == false){
                            fishh.add(new fishfishfish());
                        }
                }
            }
        });
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(peo){
				timepeo--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});

	
	playstate(){
		this.setFocusable(true);
		this.setLayout(null);
                Bnext.setBounds(690, 400, 100,100);
                Bnext.addActionListener(this);
		this.add(score);
		
		this.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			
			    if(a==KeyEvent.VK_LEFT){
			     	tn.x-=10;
                                tn.count++;
                            }
                            else if(a == KeyEvent.VK_RIGHT){
                               tn.x+=10;
                               tn.count++;
			   }
                            if(tn.count>3){
                                tn.count=0;
                            }
                            else if(a == KeyEvent.VK_DOWN){
                               tn.count=5;
			       harpoon.add(new harpoon(tn.x,60));
			    }
			
                    }
                    public void keyReleased(KeyEvent e){
                        tn.count=0;
		    }
		});
		
		tn.y = 100;
		time.start();
		actor.start();
		t.start();
                fish1.start();    
                fish2.start();

	}
       @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
                if(tn.x<0){
                    tn.x=this.getWidth()-10;
		}
		if(tn.x>this.getWidth()){
                    tn.x=20;
                }
                g.drawImage(bgff.getImage(),0, 0, 800, 600, this);
                g.drawImage(tn.imgg, tn.x, tn.y-120,250,250, this); 
            
  

                for(int i=0;i<harpoon.size();i++){
		    harpoon ba = harpoon.get(i);
                    g.drawImage(ba.imfire.getImage(), ba.x, ba.y,50,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.y<0){
		    	harpoon.remove(i);
		    }
		}		  
		//========================================nimo================= 
                for(int i=0 ; i<fish.size();i++){
                    g.drawImage(fish.get(i).getImage(),fish.get(i).getX(),fish.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<harpoon.size();i++){
		    for(int j=0 ; j<fish.size();j++){
		    	if(Intersect(harpoon.get(i).getbound(),fish.get(j).getbound())){
			    fish.remove(j);
			    harpoon.remove(i);
			    scor += 10;
			    g.drawString("+10",tn.x+100,650);
			} 
		    }
		}
		//========================shark=========================
                for(int i=0 ; i<fishh.size();i++){
                    g.drawImage(fishh.get(i).getImage(),fishh.get(i).getX(),fishh.get(i).getY(),300,300,this);
 		}                
		for(int i=0 ; i<harpoon.size();i++){
		    for(int j=0 ; j<fishh.size();j++){
		    	if(Intersect(harpoon.get(i).getbound(),fishh.get(j).getbound())){
			    fishh.remove(j);
			    harpoon.remove(i);
			    scor -= 10;
			    g.drawString("+10",tn.x+100,650);
			 } 
		    }
		}
           
           
            	g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,30, 550);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STATE "+rs1,550,50);
		g.drawString("Time "+times,600,550);
		g.setColor(Color.RED);
                
            if(times <= 0 && scor<30){   
                t.stop();
                time.stop();
                fish1.stop();
                fish2.stop();             
                g.drawImage(feildover.getImage(),0,0,800,600,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,40));		
                g.drawString("SCORE   "+scor,290,280);	     
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,70));
                g.drawString("GAME OVER ",180,210);
                }

            else if(times <= 0 && scor>=30){
                    
                    g.drawImage(feildover.getImage(),0,0,800,600,this);
                    g.setColor(Color.BLACK);
                    this.add(Bnext);
                    g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,40));		
                    g.drawString("SCORE   "+scor,290,280);	     
                    g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,70));
                    g.drawString("FINISH",280,200);
                    System.out.println("finsih2");
                
                }      
	    }

	

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
        @Override
	public void actionPerformed(ActionEvent e) {
	}
}
