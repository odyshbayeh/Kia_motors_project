package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerLoginController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;

	private Stage stage;
	private Main mainApp;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setMain(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleLogin() {
		String username = usernameField.getText();
		String password = passwordField.getText();

		if ("admin".equals(username) && "admin".equals(password)) {
			mainApp.showCombinedSceneView();
			stage.close();
		} else {
			showAlert("Invalid username or password");
		}
	}

	private void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
