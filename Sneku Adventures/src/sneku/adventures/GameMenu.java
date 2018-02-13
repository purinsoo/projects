package sneku.adventures;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Princeee
 */
public class GameMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Pane root = new Pane();
        root.setPrefSize(800,600);
        
        InputStream is = Files.newInputStream(Paths.get("assets/background.jpg"));
        Image img = new Image (is);
        is.close();
        
        ImageView imgview = new ImageView(img);
        
        root.getChildren().addAll(imgview);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
}
