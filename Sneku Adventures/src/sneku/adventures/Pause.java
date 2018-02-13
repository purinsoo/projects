

package sneku.adventures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;





public class Pause {
    
    public Rectangle resumeButton = new Rectangle(380,250,150,50);
    public Rectangle helpButton = new Rectangle(380,350,150,50);
    public Rectangle quitButton = new Rectangle(380,450,150,50);

    
   
    public void render(Graphics g){
 
        Graphics2D g2d = (Graphics2D) g;
        Font fnt0 = new Font("arial", Font.BOLD,50);
        g.setFont( fnt0);
        g.setColor(Color.WHITE);
        g.drawString("Sneku", 380,200);
        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Resume", resumeButton.x + 15, resumeButton.y + 35);
        g2d.draw(resumeButton);
        //g.drawString("", resumeButton.x + 45, resumeButton.y + 135);
        // g2d.draw(helpButton);
        g.drawString("Quit", resumeButton.x + 45, resumeButton.y + 235);
        g2d.draw(quitButton);
        
        
    }
}
