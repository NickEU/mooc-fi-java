package application;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatsView {
    private Label wordCount;

    public Parent getView() {
        HBox layout = new HBox(20);
        layout.setPadding(new Insets(5, 5, 5, 5));
        Label wordsTxt = new Label("Words in dictionary: ");
        wordCount = new Label("0");
        layout.getChildren().addAll(wordsTxt, wordCount);

        return layout;
    }

    void incWordCounter() {
        int curCount = Integer.parseInt(wordCount.getText());
        wordCount.setText(String.valueOf(curCount + 1));
    }
}
