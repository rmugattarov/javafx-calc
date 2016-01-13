package rmugattarov;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by rmugattarov on 12.01.2016.
 */
public class CalcController {
    public Label display;
    public Button CE;
    public Button C;
    public Button backSpace;
    public Button divide;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button multiply;
    public Button four;
    public Button five;
    public Button six;
    public Button minus;
    public Button one;
    public Button two;
    public Button three;
    public Button plus;
    public Button plusMinus;
    public Button zero;
    public Button dot;
    public Button equals;

    @FXML
    public void initialize() {
        zero.setOnAction(new DigitHandler());
        one.setOnAction(new DigitHandler());
        two.setOnAction(new DigitHandler());
        three.setOnAction(new DigitHandler());
        four.setOnAction(new DigitHandler());
        five.setOnAction(new DigitHandler());
        six.setOnAction(new DigitHandler());
        seven.setOnAction(new DigitHandler());
        eight.setOnAction(new DigitHandler());
        nine.setOnAction(new DigitHandler());
    }

    private class DigitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String displayText = display.getText();
            String thisDigit = ((Button) event.getSource()).getText();
            String newDisplayText;
            if (displayText == null || displayText.isEmpty() || displayText.equals("0")) newDisplayText = thisDigit;
            else if (displayText.length() < 13) newDisplayText = displayText.concat(thisDigit);
            else newDisplayText = displayText;
            display.setText(newDisplayText);
        }
    }
}
