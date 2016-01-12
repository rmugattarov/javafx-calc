package rmugattarov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by rmugattarov on 12.01.2016.
 */
public class Calc extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Calc.class.getClassLoader().getResource("Calc.fxml"));
        Scene scene = new Scene(root, 300, 450);
        stage.setTitle("Calc");
        stage.setScene(scene);
        stage.getIcons().add(new Image("letterC.png"));
        stage.show();
    }
}
