package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stage;
	
	private static Scene loginScene;
	private static Scene homeScene;
	
	@Override
	public void start(Stage stage) {
		try {
				
				Main.stage = stage; 
				stage.setTitle("Central de Procedures");
				
				Parent parentLogin = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
				loginScene = new Scene(parentLogin);
				
				Parent parentHome = FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
				homeScene = new Scene(parentHome);
								
				stage.setScene(loginScene);
				stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void mudarTela(String scr) {
		
		switch (scr) {
		case "login":
			stage.setScene(loginScene);
		case "home":
			stage.setScene(homeScene);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

