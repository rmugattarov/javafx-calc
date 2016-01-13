package rmugattarov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by rmugattarov on 12.01.2016.
 */
public class CalcController {
    public Label display;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleDigitButton(ActionEvent event) {
        String displayText = display.getText();
        String thisDigit = ((Button) event.getSource()).getText();
        String newDisplayText;
        if (displayText == null || displayText.isEmpty() || displayText.equals("0")) newDisplayText = thisDigit;
        else if (displayText.length() < 13) newDisplayText = displayText.concat(thisDigit);
        else newDisplayText = displayText;
        display.setText(newDisplayText);
    }
}
