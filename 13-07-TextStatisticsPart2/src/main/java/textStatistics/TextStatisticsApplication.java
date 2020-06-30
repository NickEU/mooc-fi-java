package textStatistics;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class TextStatisticsApplication extends Application {
    TextArea userArea;
    Label letterCountLabel;
    Label wordCountLabel;
    Label longestWordText;

    @Override
	public void start(Stage window) {
        BorderPane layout = new BorderPane();
        userArea = new TextArea("");

        layout.setBottom(setupBottomLabels());
        layout.setCenter(userArea);
        setupEventHandlers();

        Scene view = new Scene(layout);
        window.setTitle("Text Statistics");
        window.setScene(view);
        window.show();
    }

    private Node setupBottomLabels() {
        HBox bottomLabels = new HBox(20);
        letterCountLabel = new Label("Letters: 0");
        wordCountLabel = new Label("Words: 0");
        longestWordText = new Label("The longest word is: ");
        bottomLabels.getChildren().addAll(letterCountLabel, wordCountLabel, longestWordText);
        return bottomLabels;
    }

    private void setupEventHandlers() {
        userArea.textProperty().addListener((change, oldValue, newValue) -> {
            AtomicReference<String> longestWord = new AtomicReference<>("");
            AtomicInteger letterCount = new AtomicInteger(0);

            String[] words = newValue.split(" ");
            String wordCount = Arrays.stream(words)
                .reduce("0", (acc, curr) -> {
                    String normalizedWord = curr.replaceAll("(?i)[^a-z]", "");
                    letterCount.getAndAdd(normalizedWord.length());
                    if (normalizedWord.length() > longestWord.get().length()) {
                         longestWord.set(normalizedWord);
                    }
                    return normalizedWord.isEmpty()
                        ? acc : String.valueOf(Integer.parseInt(acc) + 1);
                });

            wordCountLabel.setText("Words: " + wordCount);
            letterCountLabel.setText("Letters: " + letterCount.get());
            longestWordText.setText("The longest word is: " + longestWord.get());
        });
    }
	public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
// mvn -e exec:java -Dexec.mainClass="src.main.java.textStatistics.TextStatisticsApplication"