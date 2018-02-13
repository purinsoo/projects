package sneku.adventures;


import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;





public class SnekuAdventures {

   
    public static void main(String[] args) {
      
      
        JFrame obj = new JFrame("Sneku Adventures");
        ImageIcon img = new ImageIcon("C:\\Users\\Princeee\\Desktop\\java codes\\Sneku Adventures\\src\\sneku\\adventures\\icon.jpg");
        obj.setIconImage(img.getImage());
        Gameplay gameplay = new Gameplay();
        
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
     
    } 
   
}

