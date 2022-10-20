package gui;

import javax.swing.JOptionPane;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.UsuariosDao;


public class ViewController {

	@FXML
	private TextField txtLogin;
	
	@FXML
	private PasswordField txtSenha;
	
	@FXML
	private Label labelResult;
	
	@FXML
	private Button btLogin;
	
	@FXML
	public boolean onBtSumClick() throws Exception {
		boolean check = false;
		try {
			 UsuariosDao dao = DaoFactory.createUsuarioDao();
			    if(dao.checkLogin(txtLogin.getText(), txtSenha.getText() )){
		    	   JOptionPane.showMessageDialog(null, "Bem vindo!");
		    	   Main.mudarTela("home");
		    	   check = true;
	           	    
		       }else{
		           JOptionPane.showMessageDialog(null, "Senha incorreta!");
		           check = false; 
		       }
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
		
		return check;
	}


}
