package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private final Dictionary dictionary;
    private TextField transField;
    private TextField wordField;
    private Label feedbackLbl;
    private StatsView statsView;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;

    }

    public Parent getView(StatsView statsViewBuilder) {
        this.statsView = statsViewBuilder;
        GridPane layout = new GridPane();

        Label wordLbl = new Label("Word");
        wordField = new TextField();
        Label transLbl = new Label("Translation");
        transField = new TextField();
        Button addToDictBtn = new Button("Enter new words");

        feedbackLbl = MainMenuView.buildFeedbackLabel();

        addToDictBtn.setOnAction(e -> onAddBtnClick());

        layout.addColumn(0, wordLbl, wordField, transLbl, transField, addToDictBtn, feedbackLbl);

        MainMenuView.setupLayoutPosition(layout);

        return layout;
    }

    private void onAddBtnClick() {
        String word = wordField.getText();
        String translation = transField.getText();
        switch (dictionary.addPair(word, translation)) {
            case NEW_ENTRY:
                feedbackLbl.setText("Successfully added " + word + " to dictionary!");
                statsView.incWordCounter();
                break;
            case UPDATED:
                feedbackLbl.setText("Successfully updated the translation of " + word);
                break;
            case FAILED:
                feedbackLbl.setText("Error!");
                break;
        }
        wordField.setText("");
        transField.setText("");
    }
}
