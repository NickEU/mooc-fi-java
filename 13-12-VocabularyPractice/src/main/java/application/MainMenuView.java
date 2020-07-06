package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainMenuView {
    final static int MAX_EL_WIDTH = 420;
    private BorderPane layout;
    private final Dictionary dictionary = new Dictionary();
    private final InputView inputViewBuilder = new InputView(dictionary);
    private final PracticeView practiceViewBuilder = new PracticeView(dictionary);
    final StatsView statsViewBuilder = new StatsView();

    public Parent getView() {
        layout = new BorderPane(inputViewBuilder.getView(statsViewBuilder));
        layout.setTop(buildMainMenuView());
        layout.setBottom(statsViewBuilder.getView());
        return layout;
    }

    private Parent buildMainMenuView() {
        HBox view = new HBox(25);
        view.setPadding(new Insets(20, 20, 20, 20));
        Button inputBtn = new Button("Enter new words");
        Button practiceBtn = new Button("Practice");
        view.setAlignment(Pos.CENTER);
        view.getChildren().addAll(inputBtn, practiceBtn);

        inputBtn.setOnAction(e -> layout.setCenter(inputViewBuilder.getView(statsViewBuilder)));
        practiceBtn.setOnAction(e -> layout.setCenter(practiceViewBuilder.getView()));

        return view;
    }

    static Label buildFeedbackLabel() {
        Label feedbackLbl = new Label("");
        feedbackLbl.setWrapText(true);
        feedbackLbl.setPrefWidth(MAX_EL_WIDTH);
        feedbackLbl.setMaxWidth(MAX_EL_WIDTH);
        return feedbackLbl;
    }

    static void setupLayoutPosition(GridPane layout) {
        layout.setHgap(10);
        layout.setVgap(20);
        layout.setAlignment(Pos.CENTER);
        for (Node el : layout.getChildren()) {
            GridPane.setHalignment(el, HPos.CENTER);
            GridPane.setMargin(el, new Insets(5, 15, 20, 15));
        }
    }

    static void setupWindowProps(Stage window) {
        window.setMinHeight(MAX_EL_WIDTH - 20);
        window.setMinWidth(MAX_EL_WIDTH + 30);
        window.setTitle("Dictionary");
    }
}
