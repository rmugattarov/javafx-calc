package rmugattarov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;

/**
 * Created by rmugattarov on 12.01.2016.
 */
public class CalcController {
    public static final int INPUT_LIMIT = 13;
    private static final DecimalFormat DECIMAL_FORMAT;

    static {
        DECIMAL_FORMAT = new DecimalFormat();
        DECIMAL_FORMAT.setParseBigDecimal(true);
        DECIMAL_FORMAT.setMaximumIntegerDigits(INPUT_LIMIT - 1);
        DECIMAL_FORMAT.setMaximumFractionDigits(INPUT_LIMIT - 2);
        DECIMAL_FORMAT.setMinimumFractionDigits(0);
        DECIMAL_FORMAT.setMinimumIntegerDigits(1);
        System.out.printf("current decimal pattern : %s", DECIMAL_FORMAT.toPattern());

    }
    public Label display;
    private BigDecimal firstOperand;
    private Operation operation;
    private boolean isSecondOperand;

    @FXML
    private void handleDigitButton(ActionEvent event) {
        String displayText = display.getText();
        String thisDigit = ((Button) event.getSource()).getText();
        String newDisplayText;
        if (displayText == null || displayText.isEmpty() || displayText.equals("0") || isSecondOperand) newDisplayText = thisDigit;
        else if (displayText.length() < INPUT_LIMIT) newDisplayText = displayText.concat(thisDigit);
        else newDisplayText = displayText;
        display.setText(newDisplayText);
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        operation = Operation.fromString(((Button) event.getSource()).getText());
        if (isSecondOperand) {
            BigDecimal secondOperand = (BigDecimal) DECIMAL_FORMAT.parse(display.getText(), new ParsePosition(0));
            BigDecimal result;
            switch (operation) {
                case ADDITION:
                    result = firstOperand.add(secondOperand);
                    break;
                case SUBTRACTION:
                    result = firstOperand.subtract(secondOperand);
                    break;
                case MULIPLICATION:
                    result = firstOperand.multiply(secondOperand);
                    break;
                case DIVISION:
                    result = firstOperand.divide(secondOperand, BigDecimal.ROUND_HALF_UP);
                    break;
                default:
                    result = BigDecimal.ZERO;
                    break;
            }
            isSecondOperand = false;
            display.setText(DECIMAL_FORMAT.format(result));
        } else {
            firstOperand = (BigDecimal) DECIMAL_FORMAT.parse(display.getText(), new ParsePosition(0));
            isSecondOperand = true;
        }
    }

    @FXML
    public void handleDot(ActionEvent event) {
        String displayText = display.getText();
        if (displayText.contains(".")) {
            // do nothing
        } else {
            display.setText(displayText + ".");
        }
    }
}
