
package get.out;

import java.awt.*;
import javax.swing.*;


public class Player {
    
    
    
    private int tileX,tileY;
    private Image player;
    public Player()
    {
        
        ImageIcon img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\player.png");
        player=img.getImage();

        tileX=1;
        tileY=1;
    }
    public Image getPlayer()
    {
        return player;
    }
      public int getTileX()
    {
        return tileX;
    }
       public int getTileY()
    {
        return tileY;
    }
    
    public void move(int dx,int dy)
    {
        tileX+=dx;
        tileY+=dy;
    }
    
}
