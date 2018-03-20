
package get.out;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Map {
    
    private Scanner m;
    private String Map[] = new String[14];
    private Image grass,
                  finish,
                  trap,
                  wall;
    public Map()
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
        m = new Scanner(new File("C:\\Users\\Princeee\\Desktop\\java codes\\Get Out\\src\\assets\\Map.txt"));
        }catch(Exception e)
        {
            System.out.println("Error Loading Map");
        }
    }
    public void readFile()
    {
        while(m.hasNext())
        {
            for(int i=0; i<14; i++)
            {
                Map[i] = m.next();
            }
        }
    }
    public void closeFile()
    {
        m.close();
    }
}
