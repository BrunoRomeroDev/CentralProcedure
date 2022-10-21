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
	private static Scene sesauScene;
	private static Scene sobreScene;
	
	@Override
	public void start(Stage stage) {
		try {
				
				Main.stage = stage; 
				stage.setTitle("Central de Procedures");
								
				Parent parentLogin = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
				loginScene = new Scene(parentLogin);
				stage.setScene(loginScene);
				stage.show();

				
				Parent parentSesau = FXMLLoader.load(getClass().getResource("/gui/HomeSesau.fxml"));
				sesauScene = new Scene(parentSesau);
				
				Parent parentHome  = FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
				homeScene = new Scene(parentHome);
				
				Parent parentSobre = FXMLLoader.load(getClass().getResource("/gui/Sobre.fxml"));
				sobreScene = new Scene(parentSobre);
								

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void mudarTela(String scr) {
		
		switch (scr) {
		case "login":
			stage.setScene(loginScene);
			break;
		case "home":
			stage.setScene(homeScene);
			break;
		case "homesesau":
			stage.setScene(sesauScene);
			break;			
		case "sobre":
			stage.setScene(sobreScene);
			break;

		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

