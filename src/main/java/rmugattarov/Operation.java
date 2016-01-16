package rmugattarov;

/**
 * Created by rmugattarov on 17.01.2016.
 */
public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULIPLICATION("\u00D7"),
    DIVISION("\u00F7"),
    EQUALS("=");

    private String operatorAsString;

    Operation(String operatorAsString) {
        this.operatorAsString = operatorAsString;
    }

    public String asString() {
        return operatorAsString;
    }

    public static Operation fromString(String operatorAsString) {
        Operation result;
        switch (operatorAsString) {
            case "+":
                result = ADDITION;
                break;
            case "\u2212":
                result = SUBTRACTION;
                break;
            case "\u00D7":
                result = MULIPLICATION;
                break;
            case "\u00F7":
                result = DIVISION;
                break;
            case "=":
                result = MULIPLICATION;
                break;
            default:
                throw new IllegalArgumentException("Cannot parse string argument into an Operation.");
        }
        return result;
    }
}
