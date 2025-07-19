package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private VBox loginForm;

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

		if (authenticate(username, password)) {
			if ("admin".equals(username) && "admin".equals(password)) {
				mainApp.showCombinedSceneView();
			} else if ("ody".equals(username) && "1".equals(password)) {
				mainApp.showDashboardView();
			}
			stage.close();
		} else {
			showAlert("Invalid username or password");
		}
	}

	private boolean authenticate(String username, String password) {
		return ("admin".equals(username) && "admin".equals(password))
				|| ("ody".equals(username) && "1".equals(password));
	}

	private void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@FXML
	private void showManagerLogin() {
		showLoginWindow("ManagerLogin.fxml", "Manager Login");
	}

	@FXML
	private void showSalesmanLogin() {
		showLoginWindow("SalesmanLogin.fxml", "Salesman Login");
	}

	private void showLoginWindow(String fxmlFile, String title) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
			Parent root = loader.load();

			Stage loginStage = new Stage();
			loginStage.setTitle(title);
			loginStage.initModality(Modality.APPLICATION_MODAL);
			loginStage.initOwner(stage);
			loginStage.setScene(new Scene(root));

			if (fxmlFile.equals("ManagerLogin.fxml")) {
				ManagerLoginController controller = loader.getController();
				controller.setStage(loginStage);
				controller.setMain(mainApp);
			} else if (fxmlFile.equals("SalesmanLogin.fxml")) {
				SalesmanLoginController controller = loader.getController();
				controller.setStage(loginStage);
				controller.setMain(mainApp);
			}

			loginStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			showAlert("Failed to open login window.");
		}
	}
}


