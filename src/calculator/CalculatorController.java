package calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
	StringProperty firstInputString;
	StringProperty secondInputString;
	StringProperty resultLabelString;
	StringProperty operatorString;
	Boolean hasDecimal;
	
	@FXML
	Button oneButton;
	@FXML
	Button twoButton;
	@FXML
	Button threeButton;
	@FXML
	Button fourButton;
	@FXML
	Button fiveButton;
	@FXML
	Button sixButton;
	@FXML
	Button sevenButton;
	@FXML
	Button eightButton;
	@FXML
	Button nineButton;
	@FXML
	Button zeroButton;
	@FXML
	Button minusButton;
	@FXML
	Button addButton;
	@FXML
	Button multiplyButton;
	@FXML
	Button divideButton;
	@FXML
	Button clearButton;
	@FXML
	Label resultLabel;
	@FXML
	Button decimalButton;
	
	@FXML
	private void initialize() {
		firstInputString = new SimpleStringProperty("");
		secondInputString = new SimpleStringProperty("");
		operatorString = new SimpleStringProperty("");
		resultLabelString = new SimpleStringProperty("");
		resultLabel.textProperty().bind(resultLabelString);
		hasDecimal = false;
	}
	
	private Boolean isDecimal(Button btn) {
		return btn.getText().equals(".");
	}
	
	@FXML
	private void numberButtonClicked(ActionEvent event) {
		Button btn = (Button) event.getSource();

		if((!hasDecimal && isDecimal(btn)) || !isDecimal(btn)) {
			if(operatorString.get().isEmpty()) {
				firstInputString.set(firstInputString.get() + btn.getText());
				resultLabelString.set(firstInputString.get());
			}
			else {
				secondInputString.set(secondInputString.get().concat(btn.getText()));
				resultLabelString.set(secondInputString.get());
			}
		}
		
		if(isDecimal(btn)) {
			hasDecimal = true;
		}
	}
	
	@FXML
	private void operatorButtonClicked(ActionEvent event) {
		Button btn = (Button) event.getSource();
		operatorString.set(btn.getText());
		resultLabelString.set("");
		hasDecimal = false;
	}
	
	@FXML
	private void equalsButtonClicked() {
		if(secondInputString.get().isEmpty()) {
			resultLabelString.set(firstInputString.get());
		}
		else {
			Float one = Float.parseFloat(firstInputString.get());
			Float two = Float.parseFloat(secondInputString.get());
			Float result = new Float(0);
			if(operatorString.get().equals("+")) {
				result = one + two;
			}
			else if(operatorString.get().equals("-")) {
				result = one - two;
			}
			else if(operatorString.get().equals("*")) {
				result = one * two;
			}
			else {
				result = one / two;
			}
			resultLabelString.set(Float.toString(result).replaceAll("\\.?0*$", ""));
			firstInputString.set(Float.toString(result).replaceAll("\\.?0*$", ""));
			secondInputString.set("");
			operatorString.set("");
			
			hasDecimal = firstInputString.get().contains(".");
		}
	}
	
	@FXML
	private void clearButtonClicked() {
		firstInputString.set("");
		secondInputString.set("");
		operatorString.set("");
		resultLabelString.set("");
		hasDecimal = false;
	}
}
