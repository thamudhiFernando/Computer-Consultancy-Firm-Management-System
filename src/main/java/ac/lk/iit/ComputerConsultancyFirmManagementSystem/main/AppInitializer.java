package ac.lk.iit.ComputerConsultancyFirmManagementSystem.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeLogin.fxml"));
        primaryStage.setTitle("Computer Consultancy Firm Management System");
        primaryStage.setScene(new Scene(root, 1133, 646));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
