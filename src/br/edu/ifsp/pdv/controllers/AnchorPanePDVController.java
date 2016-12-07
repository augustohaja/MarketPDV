package br.edu.ifsp.pdv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ifsp.pdv.models.Item;
import br.edu.ifsp.pdv.models.Produto;
import br.edu.ifsp.pdv.som.TocarSom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AnchorPanePDVController implements Initializable{
	@FXML
	private TableView<Item> tableViewItens;
	@FXML
	private TableColumn<Item,Long> tableColumnCod;
	@FXML
	private TableColumn<Item,String> tableColumnDescricao;
	@FXML 
	private TableColumn<Item,Integer> tableColumnQuantidade;
	@FXML 
	private TableColumn<Item,Double> tableColumnPrecoUnitario;
	@FXML 
	private TableColumn<Item,Double> tableColumnSubTotal;
	@FXML 
	private TextField textFieldCod;
	@FXML 
	private TextField textFieldQuantidade;
	@FXML 
	private Button buttonGravar;
	@FXML 
	private Button buttonSair;
	@FXML 
	private Button buttonAdicionar;
	@FXML
	private Label labelTotal;
	@FXML
	private TextField textFieldPagamento;
	@FXML
	private Label labelTroco;
	@FXML
	private AnchorPane anchorPanePDV;
	
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ObservableList<Item> itemObservableList;
	//private StudentDAO dao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadTableViewItem();
		// Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        this.tableViewItens.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectItemTableViewItens(newValue));
	}
	
	private void loadTableViewItem() {
		//this.itemList = this.dao.all();
		
		// a string é o nome do atributo da classe do objeto
		this.tableColumnCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
		this.tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		this.tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		this.tableColumnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
		this.tableColumnSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
		
		// conversão de ArrayList para ObservableList
		this.itemObservableList = FXCollections.observableArrayList(this.itemList);
		this.tableViewItens.setItems(this.itemObservableList);
	}
	
	public void selectItemTableViewItens(Item item) {
		System.out.println(item);		
	}
	
	@FXML
	public void handleButtonFecharCompra(){
		
		
//		//this.itemList = new ArrayList<Item>();
//		this.itemList.clear();
//		this.tableViewItens.refresh();
//		System.out.println("Gravei!");
	}
	
	@FXML
	public void handleButtonSair() throws IOException{
		//this.anchorPanePDV.getParent();
	}
	
	@FXML
	public void handleButtonAdicionar() throws IOException {
		ArrayList<Produto> produtoList = retornaCadastroProdutos(); 
		Item itemDigitado = new Item();
		Item itemAtual = new Item();
		Boolean achouProduto = false;
		Boolean achouItem = false;
		
		if (textFieldQuantidade.getLength()==0){
			textFieldQuantidade.setText("0");
		}
		
		if ((textFieldCod.getLength() > 0) && (Integer.parseInt(textFieldQuantidade.getText()) > 0)) {
			for (Produto prod : produtoList) {
				if (prod.getCod().equals(Long.parseLong(textFieldCod.getText()))) {
					itemDigitado.setCod(prod.getCod());
					itemDigitado.setDescricao(prod.getDescricao());
					itemDigitado.setPrecoUnitario(prod.getPrecoUnitario());
					itemDigitado.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
					itemDigitado.setSubTotal(itemDigitado.getQuantidade() * itemDigitado.getPrecoUnitario());
					achouProduto = true;
					for (Item it : itemList) {
						if (it.getCod().equals(itemDigitado.getCod())) {
							achouItem = true;
							itemAtual = itemList.get(itemList.indexOf(it));
							itemAtual.setQuantidade(itemAtual.getQuantidade() + itemDigitado.getQuantidade());
							itemAtual.setSubTotal(itemAtual.getQuantidade() * itemAtual.getPrecoUnitario());
							this.tableViewItens.refresh();
						}
					}
					if (!achouItem) {
						itemList.add(itemDigitado);
					}
					atualizaTotais();
				}
			}
		}
		
		if (!achouProduto){
			//Mensagem de produto n�o cadastrado
			JOptionPane.showMessageDialog(null,"C�digo n�o encontrado.");
		} else if (Integer.parseInt(textFieldQuantidade.getText())<1){
			JOptionPane.showMessageDialog(null,"A quantidade deve ser maior que zero.");
		} else {
			TocarSom.play();
		}

		textFieldCod.setText("");
		textFieldQuantidade.setText("");
		
		loadTableViewItem();
	}
	
	public ArrayList<Produto> retornaCadastroProdutos(){
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		produtoList.add(new Produto(1L,"Produto 1",1.0));
		produtoList.add(new Produto(2L,"Produto 2",2.0));
		produtoList.add(new Produto(3L,"Produto 3",3.0));
		produtoList.add(new Produto(4L,"Produto 4",4.0));
		produtoList.add(new Produto(5L,"Produto 5",5.0));
		produtoList.add(new Produto(6L,"Produto 6",6.0));
		produtoList.add(new Produto(7L,"Produto 7",7.0));
		produtoList.add(new Produto(8L,"Produto 8",8.0));
		produtoList.add(new Produto(9L,"Produto 9",9.0));
		produtoList.add(new Produto(10L,"Produto 10",10.0));
		return produtoList;
	}
	
	@FXML
	public void atualizaTotais(){
		Double total = 0.0;
		
		if (itemList.size() > 0){
			for (Item it : itemList){
				total += it.getSubTotal(); 
			}
			labelTotal.setText(total.toString());
		}
	}
}
