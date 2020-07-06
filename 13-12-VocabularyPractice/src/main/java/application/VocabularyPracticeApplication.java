package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {
    private final MainMenuView mainViewBuilder = new MainMenuView();

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage window) {
        Scene main = new Scene(mainViewBuilder.getView());

        window.setScene(main);
        MainMenuView.setupWindowProps(window);
        window.show();
    }
}
