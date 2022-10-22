package gui;

import java.io.IOException;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.Main;
import gui.util.Alerts;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.dao.ServicesDao;


public class Home extends Application {
	
	@FXML
	private Label msg;
	
	@FXML
	private Button btSesau;
	
	@FXML
	private MenuItem menuHome;
	
	@FXML
	private MenuItem menuSobre;
	
			
	public Home() {
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
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
