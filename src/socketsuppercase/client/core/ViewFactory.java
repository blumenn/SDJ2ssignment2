package socketsuppercase.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import socketsuppercase.client.views.ViewController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory {
    private static Map<String, Scene> scenes;
    private static Stage stage;

    static {
        scenes = new HashMap<>();
    }

    public static void init(Stage theStage) {
        stage = theStage;
        createScene("Uppercase");
        createScene("Log");
    }

    private static void createScene(String sceneName) {
        Scene scene = null;
        if (sceneName.equals("Uppercase")) {
            try {
                System.out.println("Create uppercase");
                Parent root = loadFXML("../views/uppercase/UppercaseView.fxml");

                stage.setTitle("Upper case");
                scene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (sceneName.equals("Log")) {
            try {
                System.out.println("Log");
                Parent root = loadFXML("../views/log/Log.fxml");

                scene = new Scene(root);
                stage.setTitle("Log");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scenes.put(sceneName, scene);
    }

    private static Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewFactory.class.getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
        return root;
    }

    public static Scene getScene(String sceneName) {
        return scenes.get(sceneName);
    }
}
