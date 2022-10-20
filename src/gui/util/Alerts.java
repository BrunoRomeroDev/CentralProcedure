package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class Alerts {

	public static void showAlert(String title, String header, String labelResult, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(labelResult);
		alert.show();
	}
	
	public static void showAlert(String title, String header,AlertType type) {
	Alert alert = new Alert(type);
	alert.setTitle(title);
	alert.setHeaderText(header);
	}
}
