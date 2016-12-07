package br.edu.ifsp.pdv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ifsp.pdv.models.Item;
import br.edu.ifsp.pdv.models.Sessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	@FXML
	private AnchorPane anchorPaneFecharCompra;

	private Double troco;

	public void calcularTroco() {
		if (Double.parseDouble(txtValorDoPagamento.getText()) > Sessao.getTotal()) {
			this.troco = Double.parseDouble(txtValorDoPagamento.getText()) - Sessao.getTotal();
			lblTroco.setText(this.troco.toString());
		} else
			JOptionPane.showMessageDialog(null, "O valor de pagamento deve ser maior do que o valor total!");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblVlrTotal.setText(Sessao.getTotal().toString());

	}

	@FXML
	public void handleButtonFinalizarCompra() throws IOException {
		AnchorPane ap = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/br/edu/ifsp/pdv/views/AnchorPanePDV.fxml"));
		this.anchorPaneFecharCompra.getChildren().setAll(ap);
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
	}

}
