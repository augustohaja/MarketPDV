package br.edu.ifsp.pdv.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.ifsp.pdv.models.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneFecharCompraController implements Initializable {

	@FXML
	private Button buttonFinalizarCompra;
	@FXML
	private TextField txtValorDoPagamento;
	@FXML
	private Label lblVlrTotal;
	@FXML
	private Label lblTroco;
	@FXML
	private AnchorPane anchorPane;
	
	private Double total;
	
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.lblVlrTotal.setText(this.total.toString());

	}

}
