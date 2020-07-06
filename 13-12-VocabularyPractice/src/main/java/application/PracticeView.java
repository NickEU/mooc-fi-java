package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private final Dictionary dictionary;
    private Label feedbackLbl;
    private Label wordLbl;
    private TextField wordField;
    private String testWord;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        wordLbl = new Label();
        updateWordLabel();

        wordField = new TextField();
        Button checkBtn = new Button("Check");

        checkBtn.setOnAction(e -> onCheckBtnClick());

        feedbackLbl = MainMenuView.buildFeedbackLabel();

        layout.addColumn(0, wordLbl, wordField, checkBtn, feedbackLbl);
        MainMenuView.setupLayoutPosition(layout);

        return layout;
    }

    private void updateWordLabel() {
        testWord = dictionary.getRandomWord();
        wordLbl.setText("Translate the word '" + testWord + "'");
    }

    private void onCheckBtnClick() {
        String translation = dictionary.translate(testWord);
        String userInput = wordField.getText();
        if (userInput.isEmpty()) return;

        String response =
                translation.equals(userInput)
                        ? "Correct!"
                        : String.format(
                        "Incorrect! The translation of the word '%s' is '%s'",
                        testWord, translation);

        feedbackLbl.setText(response);
        updateWordLabel();
    }
}
