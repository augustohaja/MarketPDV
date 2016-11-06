package br.edu.ifsp.pdv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class VBoxAppController implements Initializable{
	@FXML
	private Menu menuCadastros;
	@FXML
	private Menu menuVendas;
	@FXML
	private MenuItem menuItemVendasPDV;
	@FXML
	private Menu menuAjuda;
	@FXML 
	private MenuItem menuItemSobre;
	@FXML
	private AnchorPane anchorPane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void handleMenuItemVendasPDV() throws IOException{
		AnchorPane ap = (AnchorPane) FXMLLoader.load(getClass().getResource("/br/edu/ifsp/pdv/views/AnchorPanePDV.fxml"));
		this.anchorPane.getChildren().setAll(ap); 
	}

}
