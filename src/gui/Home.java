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
	private Button btAcesso;
	
	@FXML
	private Button btDerruba;
	
	@FXML
	private Button btConsulta;
	
	@FXML
	private MenuItem menuSesau;
	
	@FXML
	private MenuItem menuHome;
	
	@FXML
	private MenuItem menuSobre;
	
	public void onbuttonAcesso() {
		try {
		      JTextField chapa = new JTextField(6);
		      JTextField intruso = new JTextField(1);

		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("Chapa/Registro"));
		      myPanel.add(chapa);
		      myPanel.add(Box.createHorizontalStrut(15)); 
		      myPanel.add(new JLabel("Operação"));
		      myPanel.add(intruso);

		      int result = JOptionPane.showConfirmDialog(null, myPanel,
		               "Entre com os dados da usuário", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {

					ServicesDao sd = DaoFactory.execProcedure();
					sd.execProcedurePMSVAcesso(Integer.parseInt(chapa.getText()),intruso.getText());
		      }

					
		}catch (NullPointerException e) {
			Alerts.showAlert("Error", "NullPointerException", e.getMessage(), AlertType.ERROR);
		}
	
	}
	
	public void onbtDerruba() {
		try {
		      JTextField chapa = new JTextField(6);

		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("Chapa/Registro"));
		      myPanel.add(chapa);
		      myPanel.add(Box.createHorizontalStrut(15)); 


		      int result = JOptionPane.showConfirmDialog(null, myPanel,
		               "Entre com os dados da usuário", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {

					ServicesDao sd = DaoFactory.execProcedure();
					sd.execProcedurePMSVDerruba(Integer.parseInt(chapa.getText()));
		      }

					
		}catch (NullPointerException e) {
			Alerts.showAlert("Error", "NullPointerException", e.getMessage(), AlertType.ERROR);
		}
	
	}
	
	
	public void onbuttonConsulta() {
		try {
		      JTextField chapa = new JTextField(6);
		     

		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("Chapa/Registro"));
		      myPanel.add(chapa);
		      myPanel.add(Box.createHorizontalStrut(15));		
		   

		      int result = JOptionPane.showConfirmDialog(null, myPanel,
		               "Entre com os dados da usuário", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {

					ServicesDao sd = DaoFactory.execProcedure();
					sd.ConsultaAcesso(Integer.parseInt(chapa.getText()));
		      }

					
		}catch (NullPointerException e) {
			Alerts.showAlert("Error", "NullPointerException", e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	public Home() {
		super();
		
	}
	
	@FXML
	public boolean onMenuClick() throws Exception {
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
