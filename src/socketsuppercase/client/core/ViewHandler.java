package socketsuppercase.client.core;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import socketsuppercase.client.views.ViewController;

import java.io.IOException;

public class ViewHandler {

    private static ViewHandler instance = new ViewHandler();

    public static ViewHandler getInstance(){
        return instance;
    }
    private Stage stage;

    private ViewHandler() {
    }

    public void start() {
        stage = new Stage();
        ViewFactory.init(stage);
        openToUppercase();
    }

    public void openToUppercase() {
        /*if (uppercaseScene == null) {
            try {
                Parent root = loadFXML("../views/uppercase/UppercaseView.fxml");

                stage.setTitle("Upper case");
                uppercaseScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        Scene uppercaseScene = ViewFactory.getScene("Uppercase");
        stage.setScene(uppercaseScene);
        stage.setOnCloseRequest(e -> System.out.println("Exit"));
        stage.show();
    }

    public void openLog() {

        /*if (logScene == null) {
            try {
                Parent root = loadFXML("../views/log/Log.fxml");

                logScene = new Scene(root);
                stage.setTitle("Log");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        Scene logScene=ViewFactory.getScene("Log");
        stage.setScene(logScene);
        stage.show();
    }

}
