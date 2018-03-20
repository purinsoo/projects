
package get.out;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Map1 {
    
    private Scanner m1;
    private String Map[] = new String[14];
    private Image grass,
                  finish,
                  trap,
                  wall;
    public Map1()
    {
        ImageIcon img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\grass.png");
        grass = img.getImage();
        img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\wall.png");
        wall = img.getImage();
        img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\finish.png");
        finish = img.getImage();
        img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\grass.png");
        trap = img.getImage();
        
        openFile();
        readFile();
        closeFile();
        
    }
    
    public Image getGrass()
    {
        return grass;
    }
    
     public Image getWall()
    {
        return wall;
    }

    public Image getFinish()
     {
         return finish;
     }
    public Image getTrap()
     {
         return trap;
     }
    
    public String getMap(int x, int y)
    {
        String index = Map[y].substring(x,x+1);
        return index;
    }
    
    public void openFile()
    {
        try{
        m1 = new Scanner(new File("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\Map1.txt"));
        }catch(Exception e)
        {
            System.out.println("Error Loading Map");
        }
    }
    public void readFile()
    {
        while(m1.hasNext())
        {
            for(int i=0; i<14; i++)
            {
                Map[i] = m1.next();
            }
        }
    }
    public void closeFile()
    {
        m1.close();
    }
}
