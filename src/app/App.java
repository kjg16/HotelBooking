package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(final String[] args) throws Exception {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/HotelSearch.fxml"));      
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("HotelBooking");
        stage.show();
    }    
}