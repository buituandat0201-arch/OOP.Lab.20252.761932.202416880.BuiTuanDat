package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/javafx/Painter.fxml")); [cite: 973, 974]
        Scene scene = new Scene(root); [cite: 975]
        stage.setTitle("Painter"); [cite: 976]
        stage.setScene(scene); [cite: 977]
        stage.show(); [cite: 978]
    }

    public static void main(String[] args) {
        launch(args); [cite: 980]
    }
}