
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

public class playstate2 extends JPanel implements ActionListener{
    
	

	ImageIcon feildover = new ImageIcon(this.getClass().getResource("fish2.jpg"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
	
        JButton BExit  = new JButton("EXIT");
        
        public ArrayList<harpoon> harpoon = new ArrayList<harpoon>();
	public ArrayList<fishfish> fish = new ArrayList<fishfish>();
	public ArrayList<fishfishfish> fishh = new ArrayList<fishfishfish>();
        public ArrayList<bin> b = new ArrayList<>();
        public ArrayList<tresure> tre = new ArrayList<>();
        
	private JLabel score = new JLabel(); 
        
        ImageIcon bgff= new ImageIcon(this.getClass().getResource("fish2.jpg"));
        Titanic tn=new Titanic();
	public int times=5;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean frequency = false;
	
       
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
                            if(frequency == false){
                                Thread.sleep(5000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(frequency == false){
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
                            if(frequency==false){
                                Thread.sleep(7000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(frequency == false){
                            fishh.add(new fishfishfish());
                        }
                }
            }
        });
        Thread trash = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                        try{
                            if(frequency == false){
                                Thread.sleep(5000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(frequency == false){
                            b.add(new bin());
                        }
                }
            }
        });
        Thread treasure = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                        try{
                            if(frequency==false){
                                Thread.sleep(7000);
                            }
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        if(frequency == false){
                            tre.add(new tresure());
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

	
	playstate2(){
		this.setFocusable(true);
		this.setLayout(null);
                BExit.setBounds(700, 500, 60, 60);
                BExit.addActionListener(this);
		this.add(score);
		
		this.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			if(!peo){
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
                treasure.start();
                trash.start();

	}	
        @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bgff.getImage(),0, 0, 800, 600, this);
            g.drawImage(tn.imgg, tn.x, tn.y-120,250,250, this);
            
           
            	g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,30, 550);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STATE 2",550,50);
		g.drawString("Time "+times,600,550);
		g.setColor(Color.RED);
                
            
                
		if(tn.x<0){
                    tn.x=this.getWidth()-10;
		}
		if(tn.x>this.getWidth()){
                    tn.x=20;
                    }
            
  
                for(int i=0 ; i<fish.size();i++){
                g.drawImage(fish.get(i).getImage(),fish.get(i).getX(),fish.get(i).getY(),100,100,this);
 		}
                for(int i=0 ; i<fishh.size();i++){
                g.drawImage(fishh.get(i).getImage(),fishh.get(i).getX(),fishh.get(i).getY(),300,300,this);
 		}
                for(int i=0 ; i<tre.size();i++){
                g.drawImage(tre.get(i).getImage(),tre.get(i).getX(),tre.get(i).getY(),150,150,this);
 		}
                for(int i=0 ; i<b.size();i++){
                g.drawImage(b.get(i).getImage(),b.get(i).getX(),b.get(i).getY(),200,200,this);
 		}
                for(int i=0;i<harpoon.size();i++){
		    harpoon ba = harpoon.get(i);
                    g.drawImage(ba.imfire.getImage(), ba.x, ba.y,50,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.y<0){
		    	harpoon.remove(i);
		    }
		}
		  
		
                
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
                
                
		
                
		for(int i=0 ; i<tre.size();i++){
		    g.drawImage(tre.get(i).getImage(),tre.get(i).getX(),tre.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<harpoon.size();i++){
		    for(int j=0 ; j<tre.size();j++){
		    	if(Intersect(harpoon.get(i).getbound(),tre.get(j).getbound())){
			    tre.remove(j);
			    harpoon.remove(i);
			    scor +=30;
			} 
		    }
		}
                for(int i=0 ; i<b.size();i++){
		    g.drawImage(b.get(i).getImage(),b.get(i).getX(),b.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<harpoon.size();i++){
		    for(int j=0 ; j<b.size();j++){
		    	if(Intersect(harpoon.get(i).getbound(),b.get(j).getbound())){
			    b.remove(j);
			    harpoon.remove(i);
			    scor -=15;
			} 
		    }
		}


		if(times <= 0 && scor<=100){
           
                add(BExit);
                
                g.drawImage(feildover.getImage(),0,0,800,600,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,40));		
                g.drawString("SCORE   "+scor,290,280);	     
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,70));
                g.drawString("GAME OVER",180,210);
                System.out.println("game over");
                
                }
            else if(times<=0 && scor>=100){
                
                add(BExit);
               
                g.drawImage(feildover.getImage(),0,0,800,600,this);
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,40));		
                g.drawString("SCORE   "+scor,290,280);	     
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,70));
                g.drawString("FINISH",290,200);
                System.out.println("finsih state2");
            }      
	    }

	

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
        @Override
	public void actionPerformed(ActionEvent e) {
			
	}
}
