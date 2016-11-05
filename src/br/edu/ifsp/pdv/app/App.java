package br.edu.ifsp.pdv.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifsp/pdv/views/VBoxApp.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("PDV - Ponto de Venda");
		stage.show();
	}
	
	public static void main (String[] args){
		launch(args);
	}

}
