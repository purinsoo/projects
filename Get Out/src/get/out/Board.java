
package get.out;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    private Map m;
    private Map1 m1;
    private Map2 m2;
    private Player p; 
    private int win = 0;
    private String Message = " ";
    private String Message1 = " ";
    private String Message2 = " ";
    private String Message3 = " ";
    private Font font = new Font("Serif",Font.BOLD,48);
    
    public static enum STATE
    {
        MENU,GAME
    };
    public static STATE state =STATE.MENU;
   
   
    
    public Board()
    {
        if(state == STATE.GAME){
        timer = new Timer(25,this);
        timer.start();
        m = new Map();
        m1= new Map1();
        m2= new Map2();
        p = new Player();
        addKeyListener(new Al());
        setFocusable(true);
    }}
    
    public void actionPerformed(ActionEvent e)
    {
   // if(m.getMap(p.getTileX(),p.getTileY()).equals("f"))
  //    {
    //     Message = "Winner";
   // }
      repaint();
    
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        if(win==0){
        for(int y=0; y<14; y++)
        {
            for(int x=0; x<14; x++)
            {
                if(m.getMap(x,y).equals("t"))
                {
                    g.drawImage(m.getTrap(),x*32,y*32,null);
                }
                if(m.getMap(x,y).equals("f"))
                {
                    g.drawImage(m.getFinish(),x*32,y*32,null);
                }
                if(m.getMap(x,y).equals("g"))
                {
                    g.drawImage(m.getGrass(),x*32,y*32,null);
                }
                 if(m.getMap(x,y).equals("w"))
                {
                    g.drawImage(m.getWall(),x*32,y*32,null);
                }
                
            }
        }
        g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
        }
      
        if(win==1)
        {
            
            for(int y=0; y<14; y++)
        {
            for(int x=0; x<14; x++)
            {
                if(m1.getMap(x,y).equals("t"))
                {
                    g.drawImage(m1.getTrap(),x*32,y*32,null);
                }
                if(m1.getMap(x,y).equals("f"))
                {
                    g.drawImage(m1.getFinish(),x*32,y*32,null);
                }
                if(m1.getMap(x,y).equals("g"))
                {
                    g.drawImage(m1.getGrass(),x*32,y*32,null);
                }
                 if(m1.getMap(x,y).equals("w"))
                {
                    g.drawImage(m1.getWall(),x*32,y*32,null);
                }
                
            }
        }
        g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
        }
        if(win==2)
        {
            
            for(int y=0; y<14; y++)
        {
            for(int x=0; x<14; x++)
            {
                 if(m2.getMap(x,y).equals("t"))
                {
                    g.drawImage(m2.getTrap(),x*32,y*32,null);
                }
                if(m2.getMap(x,y).equals("f"))
                {
                    g.drawImage(m2.getFinish(),x*32,y*32,null);
                }
                if(m2.getMap(x,y).equals("g"))
                {
                    g.drawImage(m2.getGrass(),x*32,y*32,null);
                }
                 if(m2.getMap(x,y).equals("w"))
                {
                    g.drawImage(m2.getWall(),x*32,y*32,null);
                }
                
            }
        }
        g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
        
        }
        if(win == 3)
        {
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(Message,50,200);
        g.setColor(Color.ORANGE);
        g.drawString(Message1,50,300);
        g.drawString(Message2,50,400);
        }
        if(win == 4)
        {
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(Message3,50,200);
        g.setColor(Color.ORANGE);
        g.drawString(Message1,50,300);
        g.drawString(Message2,50,400);
        }
    } 
        
        
    
    public class Al extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if(win==0)
            {
                int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_UP)
            {
                if(!m.getMap(p.getTileX(),p.getTileY() -1).equals("w"))    
                {
                 if(m.getMap(p.getTileX(),p.getTileY()).equals("f"))
                 {
                    win = 1;
                    Message = "winner";
                    repaint();
                 }
                  if(m.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(0,-1);
                }
                
            }
            
            if(keycode == KeyEvent.VK_DOWN)
            {
                if(!m.getMap(p.getTileX(),p.getTileY() +1).equals("w"))
                {
                    if(m.getMap(p.getTileX(),p.getTileY()).equals("f"))
                    {
                    win = 1;
                    Message = "winner";
                    repaint();      
                    }
                 if(m.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                    p.move(0,1);
                 }
            }
            if(keycode == KeyEvent.VK_LEFT)
            {
                if(!m.getMap(p.getTileX()-1,p.getTileY()).equals("w"))
                {
                    if(m.getMap(p.getTileX(),p.getTileY()).equals("f")){
                   win = 1;
                    Message = "winner";
                    repaint();
                 }
                if(m.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(-1,0);
                }
            }
            if(keycode == KeyEvent.VK_RIGHT)
            {
                if(!m.getMap(p.getTileX()+1,p.getTileY()).equals("w"))
                {
                    if(m.getMap(p.getTileX(),p.getTileY()).equals("f")){
                     win = 1;
                    Message = "winner";
                    repaint();
                 }
                    if(m.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(1,0);
                }
            }
            }
            if(win==1)
            {
                int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_UP)
            {
                if(!m1.getMap(p.getTileX(),p.getTileY() -1).equals("w"))    
                {
                 if(m1.getMap(p.getTileX(),p.getTileY()).equals("f")){
                    win = 2;
                    Message = "winner";
                    repaint();
                 }
                 if(m1.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(0,-1);
                }
                
            }
            
            if(keycode == KeyEvent.VK_DOWN)
            {
                if(!m1.getMap(p.getTileX(),p.getTileY() +1).equals("w"))
                {
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("f")){
                    win = 2;
                    Message = "winner";
                   repaint();
                 }
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(0,1);
                 }
            }
            if(keycode == KeyEvent.VK_LEFT)
            {
                if(!m1.getMap(p.getTileX()-1,p.getTileY()).equals("w"))
                {
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("f")){
                   win = 2;
                    Message = "winner";
                    repaint();
                 }
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(-1,0);
                }
            }
            if(keycode == KeyEvent.VK_RIGHT)
            {
                if(!m1.getMap(p.getTileX()+1,p.getTileY()).equals("w"))
                {
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("f")){
                     win = 2;
                    Message = "winner";
                    repaint();
                 }
                    if(m1.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(1,0);
                }
            }
            }
            if(win==2)
            {
                int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_UP)
            {
                if(!m2.getMap(p.getTileX(),p.getTileY() -1).equals("w"))    
                {
                 if(m2.getMap(p.getTileX(),p.getTileY()).equals("f")){                
                    Message = "Congratulations!"
                            + "On Beating The Game";
                    win = 3;
                    repaint();
                 }
                 if(m2.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(0,-1);
                }
                
            }
            
            if(keycode == KeyEvent.VK_DOWN)
            {
                if(!m2.getMap(p.getTileX(),p.getTileY() +1).equals("w"))
                {
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("f")){
                    Message = "Congratulations!";
                    Message1 = "press spacebar";
                    Message2 = "to play again!";
                    win = 3;
                   repaint();
                 }
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(0,1);
                 }
            }
            if(keycode == KeyEvent.VK_LEFT)
            {
                if(!m2.getMap(p.getTileX()-1,p.getTileY()).equals("w"))
                {
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("f")){
                    Message = "Congratulations!"
                            + " On Beating The Game!";
                    win = 3;
                    repaint();
                 }
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(-1,0);
                }
            }
            if(keycode == KeyEvent.VK_RIGHT)
            {
                if(!m2.getMap(p.getTileX()+1,p.getTileY()).equals("w"))
                {
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("f")){
                    Message = "Congratulations!"
                            + " On Beating The Game!";
                    win = 3;
                    repaint();
                 }
                    if(m2.getMap(p.getTileX(),p.getTileY()).equals("t"))
                  {
                      win=4;
                      Message3 = "Game Over!";
                      Message1 = "press spacebar";
                      Message2 = "to play again!";
                  }
                p.move(1,0);
                }
            }
            
            }
            if(win == 3 || win == 4)
            {
                int keycode = e.getKeyCode();
                if(keycode == KeyEvent.VK_SPACE)
                
            {
                Board.state = Board.STATE.GAME;
                 
                 new GetOut();
            }
            }
            
            }
   
        public void keyReleased(KeyEvent e)
        {
            
        }
        public void keyTyped(KeyEvent e)
        {
            
        }
    }
}
