package socketsuppercase.client;

import javafx.application.Application;
import javafx.stage.Stage;
import socketsuppercase.client.core.ClientFactory;
import socketsuppercase.client.core.ModelFactory;
import socketsuppercase.client.core.ViewHandler;
import socketsuppercase.client.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ViewHandler.getInstance().start();
    }
}
