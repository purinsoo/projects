/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sneku.adventures;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Princeee
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        int mx = e.getX();
        int my = e.getY();
        int state=0;
        
        Help gui = new Help();
        
        //play
        if(mx >= 381 && mx <= 528){
        if(my >=250 && my <= 295){
            Gameplay.state = Gameplay.STATE.GAME;
            
           
        }
        }
       
          //help
        if(mx >= 381 && mx <= 528 && state==0){
        if(my >=350 && my <= 395 && state==0){
            
            gui.setVisible(true);
            gui.pack();
            gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
        }
          //quit
        if(mx >= 381 && mx <= 528){
        if(my >=450 && my <= 495){
            System.exit(0);
        }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      
    }

    @Override
    public void mouseEntered(MouseEvent me) {
   
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
