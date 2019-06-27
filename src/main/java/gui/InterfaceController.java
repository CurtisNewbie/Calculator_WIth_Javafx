package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.CalculationAction;

public class InterfaceController {

    @FXML
    private Button num1;
    @FXML
    private Button num2;
    @FXML
    private Button num3;
    @FXML
    private Button num4;
    @FXML
    private Button num5;
    @FXML
    private Button num6;
    @FXML
    private Button num7;
    @FXML
    private Button num8;
    @FXML
    private Button num9;
    @FXML
    private Button btnCls;
    @FXML
    private Button btnBackSpace;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEqual;
    @FXML
    private Button btnMultiply;
    @FXML
    private Label btnResult;

    private StringBuilder query = new StringBuilder();

    // Calculate the numbers based on the entered query.
    public void calculate(ActionEvent e) {
	if (query.charAt(query.length() - 1) != ' ') {
	    String result = CalculationAction.parseQuery(query.toString());
	    btnResult.setText(result);
	}
    }

    // Click the numbers buttons
    public void enterNumbers(ActionEvent e) {
	// get the button's id
	String id = ((Button) e.getSource()).getId();
	switch (id) {
	case "num1":
	    query.append("1");
	    break;
	case "num2":
	    query.append("2");
	    break;
	case "num3":
	    query.append("3");
	    break;
	case "num4":
	    query.append("4");
	    break;
	case "num5":
	    query.append("5");
	    break;
	case "num6":
	    query.append("6");
	    break;
	case "num7":
	    query.append("7");
	    break;
	case "num8":
	    query.append("8");
	    break;
	case "num9":
	    query.append("9");
	    break;
	default:
	    break;
	}

	// Update display
	btnResult.setText(query.toString());
    }

    // Click the operators.
    public void selectOperator(ActionEvent e) {

	if (canAddOperator()) {
	    // get the button's id
	    String id = ((Button) e.getSource()).getId();
	    switch (id) {
	    case "btnDivide":
		query.append(" / ");
		break;
	    case "btnSub":
		query.append(" - ");
		break;
	    case "btnAdd":
		query.append(" + ");
		break;
	    case "btnMultiply":
		query.append(" * ");
		break;
	    default:
		break;
	    }
	    // Update display
	    btnResult.setText(query.toString());
	}
    }

    // remove the last character
    public void backspace(ActionEvent e) {
	int queryLen = query.length();
	if (queryLen > 0) {
	    if (query.charAt(queryLen - 1) == ' ') {
		query.delete(queryLen - 3, queryLen);
	    } else {
		query.deleteCharAt(queryLen - 1);
	    }
	    // Update display
	    btnResult.setText(query.toString());
	}
    }

    // clean screen
    public void clean(ActionEvent e) {
	query = new StringBuilder();
	// Update display
	btnResult.setText(query.toString());
    }

    // it is used to verify whether there is aleady an operator at the end of the
    // string.
    private boolean canAddOperator() {
	if (query.length() != 0) {
	    if (query.charAt(query.length() - 1) == ' ') {
		return false;
	    } else {
		return true;
	    }
	} else {
	    return false;
	}
    }

}
