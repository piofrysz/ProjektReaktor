package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main(){
        System.out.println("Konstruktor klasy Main");
    }
    @Override
    public void init(){
        System.out.println("Metoda init() klasy Main");
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/app/views/LoginView.fxml"));
        primaryStage.setTitle("Admin Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void stop(){
        System.out.println("Metoda stop() klasy Main");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
