package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		showLogin();
	}

	public void showLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Login.fxml"));
			AnchorPane loginLayout = loader.load();

			Stage loginStage = new Stage();
			loginStage.setTitle("Login");
			Scene scene = new Scene(loginLayout);
			loginStage.setScene(scene);

			LoginController controller = loader.getController();
			controller.setStage(loginStage);
			controller.setMain(this);

			loginStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showCombinedSceneView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CombinedScece.fxml"));
			BorderPane mainLayout = loader.load();

			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Combined Scene");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showDashboardView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("DashOneScene.fxml"));
			AnchorPane mainLayout = loader.load();

			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dashboard");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
