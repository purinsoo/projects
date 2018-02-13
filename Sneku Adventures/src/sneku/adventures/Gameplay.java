/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sneku.adventures;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 *
 * @author Princeee
 */
public class Gameplay extends JPanel implements KeyListener,ActionListener{

    private Menu menu;
    private Pause pause;
    
    public static enum STATE{
        MENU,
        GAME,
        PAUSE
    };
    
    public static STATE state = STATE.MENU;
    public static STATE state1 = STATE.PAUSE;
    
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private int isRunning = 1;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
   
    private int lengthofsnake=3;
    
    private Timer timer;
    private int delay = 100;
    private ImageIcon snakeimage;
   
    private int[] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,
            750,775,800,825,850};
    private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625};
     
    private ImageIcon enemyimage;
    private Random random = new Random();
    private int xpos=random.nextInt(34);
    private int ypos=random.nextInt(23);
    
    private int[] enemyxpos1={25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,
            750,775,800,825,850};
    private int[] enemyypos1={75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625};
     
    private ImageIcon enemyimage1;
    private Random random1 = new Random();
    private int xpos1=random1.nextInt(34);
    private int ypos1=random1.nextInt(23);
    
     private int[] enemyxpos2={25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,
            750,775,800,825,850};
    private int[] enemyypos2={75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625};
     
    private ImageIcon enemyimage2;
    private Random random2 = new Random();
    private int xpos2=random2.nextInt(34);
    private int ypos2=random2.nextInt(23);
    
    private int[] enemyxpos3={25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,
            750,775,800,825,850};
    private int[] enemyypos3={75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625};
     
    private ImageIcon enemyimage3;
    private Random random3 = new Random();
    private int xpos3=random3.nextInt(34);
    private int ypos3=random3.nextInt(23);
    
    private int[] ranScore={1,2,3,4,5};
    private Random random4 = new Random();
    private int xScore=random4.nextInt(5);
    
    private int[] ranLength={1,2,3,4,5};
    private Random random5 = new Random();
    private int xLength=random5.nextInt(5);
    
    
    private int score = 0;
    private int moves = 0;
    private ImageIcon titleImage;
    
    

    public Gameplay()
    {
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
        
        
    }
    public void paint(Graphics g)
    {
        this.addMouseListener(new MouseInput());
        menu = new Menu();
        pause = new Pause();
        if(state == STATE.GAME){
        if(moves == 0)
        {
            snakexlength[2]=50;
            snakexlength[1]=75;
            snakexlength[0]=100;
            
            snakeylength[2]=100;
            snakeylength[1]=100;
            snakeylength[0]=100;
           
        }
        
    g.setColor(Color.white);
    g.drawRect(24,10,851,55);
    
    titleImage = new ImageIcon("assets/snaketitle.png");
    titleImage.paintIcon(this, g, 25, 11);
    
    g.setColor(Color.BLACK);
    g.drawRect(24,74,851,577);
    
    g.setColor(Color.BLACK);
    g.fillRect(25,75,850,575);
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("arial",Font.PLAIN,14));
    g.drawString("Score:"+score, 780,30);
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("arial",Font.PLAIN,14));
    g.drawString("Current Length:"+lengthofsnake, 750,50);
    
    
    rightmouth = new ImageIcon("assets/rightmouth.png");
    rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
    
    for(int a=0; a<lengthofsnake; a++)
    {
        if(a==0 && right)
        {
        rightmouth = new ImageIcon("assets/rightmouth.png");
        rightmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        }
        if(a==0 && left)
        {   
        leftmouth = new ImageIcon("assets/leftmouth.png");
        leftmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        }
        if(a==0 && down)
        {
        downmouth = new ImageIcon("assets/downmouth.png");
        downmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        }
        if(a==0 && up)
        {
        upmouth = new ImageIcon("assets/upmouth.png");
        upmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        }
        if(a!=0)
        {
        snakeimage = new ImageIcon("assets/body.png");
        snakeimage.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        }
    }
    ////// NORMAL
    enemyimage = new ImageIcon("assets/enemy.png");
    if((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0]))
    {
     score= score+xScore;
     lengthofsnake= lengthofsnake+xLength;
     xpos=random.nextInt(34);
     ypos=random.nextInt(23);
     xLength=random5.nextInt(5);
     xScore=random4.nextInt(5);
    }
    enemyimage.paintIcon(this,g,enemyxpos[xpos],enemyypos[ypos]);
    ////// MULTIPLIER
    enemyimage = new ImageIcon("assets/enemy.png");
    if((enemyxpos1[xpos1] == snakexlength[0] && enemyypos1[ypos1] == snakeylength[0]))
    {
     score= score+xScore;
     lengthofsnake= lengthofsnake+xLength;
     xpos1=random.nextInt(34);
     ypos1=random.nextInt(23);
     xLength=random5.nextInt(5);
     xScore=random4.nextInt(5);
    }
    enemyimage.paintIcon(this,g,enemyxpos1[xpos1],enemyypos1[ypos1]);
    //////  LIFELINE
     enemyimage = new ImageIcon("assets/up2.png");
    if((enemyxpos2[xpos2] == snakexlength[0] && enemyypos2[ypos2] == snakeylength[0]))
    {
     
     lengthofsnake=lengthofsnake-3;
     xpos2=random.nextInt(34);
     ypos2=random.nextInt(23);
     if(lengthofsnake<1)
     {
            
            right = false;
            left = false;
            down = false;
            up = false;
            isRunning = 0;
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,50));
            g.drawString("Game Over",300,300);
       
            g.setFont(new Font("arial",Font.BOLD,20));
            g.drawString("Press Spacebar to play again",350,340);
     }
    }
    enemyimage.paintIcon(this,g,enemyxpos2[xpos2],enemyypos2[ypos2]);
   ///////  MORE PANGLITO
     enemyimage = new ImageIcon("assets/enemy.png");
    if((enemyxpos3[xpos3] == snakexlength[0] && enemyypos3[ypos3] == snakeylength[0]))
    {
     score= score+xScore;
     lengthofsnake= lengthofsnake+xLength;
     xpos3=random.nextInt(34);
     ypos3=random.nextInt(23);
     xLength=random5.nextInt(5);
     xScore=random4.nextInt(5);
    }
    enemyimage.paintIcon(this,g,enemyxpos3[xpos3],enemyypos3[ypos3]);
    
    for(int b = 1 ; b < lengthofsnake; b++)
    {
        if(snakexlength[b] == snakexlength[0] && snakeylength[b]== snakeylength[0])
        {
            right = false;
            left = false;
            down = false;
            up = false;
            isRunning = 0;
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,50));
            g.drawString("Game Over",300,300);
            
            g.setFont(new Font("arial",Font.BOLD,20));
            g.drawString("Press Spacebar to play again",350,340);
               
        }
        
    }
    
    
    
        }
        if(state == STATE.MENU){
        
           menu.render(g);
           
        }
        if(state == STATE.PAUSE){
           
           g.setColor(Color.BLACK);
           g.fillRect(25,75,850,575);
           pause.render(g);
           
    }
     g.dispose();   
  }

    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(state == STATE.GAME){
        if(ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(isRunning==0)
            {
                moves=0;
                score=0;
                lengthofsnake=3;
                isRunning=1;
                repaint();
            }
                   
        }
        }
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(state == STATE.GAME){
            moves++;
            right = true;
            if(!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }
            
            down = false;
            up = false;
        }
        }
         if(ke.getKeyCode() == KeyEvent.VK_LEFT)
        {   
            if(state == STATE.GAME){
            moves++;
            left = true;
            if(!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
            }
            
            down = false;
            up = false;
        }
        }
          if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            if(state == STATE.GAME){
            moves++;
            up = true;
            if(!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }
            
            left = false;
            right = false;
        }
        }
           if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(state == STATE.GAME){
            moves++;
            down = true;
            if(!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }
            
            left = false;
            right = false;
        }
        }
          
        pause = new Pause();
        if(ke.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            if(state == STATE.MENU){
            
            }
            else
            {
                Gameplay.state = Gameplay.STATE.PAUSE;
            }
                 
                 
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(state == STATE.GAME){
        timer.start();
        if(isRunning==1)
        {
        if(right)
        {
         for(int r = lengthofsnake-1; r>=0; r--)
         {
             snakeylength[r+1] = snakeylength[r];
             
         }
         for(int r = lengthofsnake; r>=0; r--)
         {
             if(r==0)
             {
                 snakexlength[r] = snakexlength[r] + 25;
             }
             else
             {
                 snakexlength[r] = snakexlength[r-1];
             }
             if(snakexlength[r] >850)
             {
                 snakexlength[r]= 25;
                 
             }
         }
         repaint();
        }
        if(left)
        {
        for(int r = lengthofsnake-1; r>=0; r--)
         {
             snakeylength[r+1] = snakeylength[r];
             
         }
         for(int r = lengthofsnake; r>=0; r--)
         {
             if(r==0)
             {
                 snakexlength[r] = snakexlength[r] - 25;
             }
             else
             {
                 snakexlength[r] = snakexlength[r-1];
             }
             if(snakexlength[r] <25)
             {
                 snakexlength[r]= 850;
                 
             }
         }
         repaint();
        }
        if(down)
        {
        for(int r = lengthofsnake-1; r>=0; r--)
         {
             snakexlength[r+1] = snakexlength[r];
             
         }
         for(int r = lengthofsnake; r>=0; r--)
         {
             if(r==0)
             {
                 snakeylength[r] = snakeylength[r] + 25;
             }
             else
             {
                 snakeylength[r] = snakeylength[r-1];
             }
             if(snakeylength[r] >625)
             {
                 snakeylength[r]= 75;
                 
             }
         }
         repaint();
        }
        if(up)
        {
        for(int r = lengthofsnake-1; r>=0; r--)
         {
             snakexlength[r+1] = snakexlength[r];
             
         }
         for(int r = lengthofsnake; r>=0; r--)
         {
             if(r==0)
             {
                 snakeylength[r] = snakeylength[r] - 25;
             }
             else
             {
                 snakeylength[r] = snakeylength[r-1];
             }
             if(snakeylength[r] <75)
             {
                 snakeylength[r]= 625;
                 
             }
         }
        }
         repaint();
        }
        }
    }
}
