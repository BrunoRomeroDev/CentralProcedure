package gui;


import java.io.IOException;

import application.Main;
import gui.util.Alerts;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Sobre extends Application {

	
	@FXML
	private Label titulo;
	
	@FXML
	private Label conteudo;
	
	@FXML
	private MenuItem menuSesau;
	
	@FXML
	private MenuItem menuHome;
	
	
	
	public Sobre() {
		super();
		
	}
	
	
	@FXML
	public boolean onMenuSesau() throws Exception {
		boolean check = false;
		try {

		    	   Main.mudarTela("homesesau");
   
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
		
		return check;
	}
	
	@FXML
	public boolean onMenuHome() throws Exception {
		boolean check = false;
		try {

		    	   Main.mudarTela("home");
   
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
		
		return check;
	}
	
	@FXML
	public boolean onMenuSobre() throws Exception {
		boolean check = false;
		try {

		    	   Main.mudarTela("sobre");
   
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
		
		return check;
	}


	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/Sobre.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
}