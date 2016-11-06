package br.edu.ifsp.pdv.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AnchorPanePDVController implements Initializable{
	@FXML
	private TableView tableViewItens;
	@FXML
	private TableColumn tableColumnCod;
	@FXML
	private TableColumn tableColumnDescricao;
	@FXML 
	private TableColumn tableColumnQuantidade;
	@FXML 
	private TableColumn tableColumnPrecoUnitario;
	@FXML 
	private TableColumn tableColumnSubTotal;
	@FXML 
	private Label labelCod;
	@FXML 
	private Label labelQuantidade;
	@FXML 
	private TextField textFieldCod;
	@FXML 
	private TextField textFieldQuantidade;
	@FXML 
	private Button buttonRemover;
	@FXML 
	private Button buttonAdicionar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
