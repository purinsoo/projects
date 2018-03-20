package get.out;
import javax.swing.*;


public class GetOut {

    public static void main(String[] args) {
       // new GetOut();
        new Menu().setVisible(true);
        

    }
    public GetOut()
    {
        JFrame f = new JFrame();
        f.setTitle("Get out!");
        f.add(new Board());
        f.setSize(464,485);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }
    
}
