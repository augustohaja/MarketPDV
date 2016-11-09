package br.edu.ifsp.pdv.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.ifsp.pdv.models.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private Button buttonRemover;
	@FXML 
	private Button buttonAdicionar;
	
	private ArrayList<Item> itemList;
	private ObservableList<Item> itemObservableList;
	//private StudentDAO dao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
		//this.dao = new StudentDAO();

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
		//this.itemObservableList = FXCollections.observableArrayList(this.itemList);
		//this.tableViewItens.setItems(this.itemObservableList);
	}
	
	public void selectItemTableViewItens(Item item) {
		System.out.println(item);
		
		/*if (student != null) {
			this.labelId.setText(String.valueOf(student.getId()));
			this.labelNome.setText(student.getName());
			this.labelIdade.setText(String.valueOf(student.getAge()));
		}*/
	}
	
	@FXML
	public void handleButtonAdicionar() throws IOException {
		//Item item = new Item(1L,"Produto Teste",5,10.5,52.5);
		//System.out.println(item.toString());
		//itemList.add(item);
		
		//loadTableViewItem();
		
		
		//boolean buttonConfirmarClicked = showAnchorPaneCadastroAlunosDialog(student);
		
		/*if (buttonConfirmarClicked) {
			this.dao.insert(student);
			loadTableViewStudent();
		}*/
	}

}
