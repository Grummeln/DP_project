package GUI_Package;

import Account_Package.Account;
import Account_Package.AccountEUR;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file using Objects.requireNonNull
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("hello-view.FXML")));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Your Banking App");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Get the controller from the loader
        AccountController controller = loader.getController();

        // For demonstration purposes, create a sample account and initialize the controller
        Account sampleAccount = new AccountEUR("EUR122", 1000.0);
        controller.initialize(sampleAccount);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
