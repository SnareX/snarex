package de.hftstuttgart.snarex.launcher;

import de.hftstuttgart.snarex.controller.Controller;
import de.hftstuttgart.snarex.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Launcher extends Application {
	
	
	

		@Override
		public void start(Stage primaryStage) throws Exception {

		    FXMLLoader loader = new FXMLLoader(getClass().getResource("de/hftstuttgart/snarex/view/View5.fxml"));
            Parent root = loader.load();
            Controller c = loader.getController();
			BorderPane outerPane = (BorderPane) FXMLLoader.load(ClassLoader.getSystemResource("de/hftstuttgart/snarex/view/View5.fxml"));
			primaryStage.setScene(new Scene(outerPane));
			primaryStage.setTitle("Snarex");
			primaryStage.show();
			
			
		}
		
		
		
		public static void main (String[]args) {
			launch(args);
		}

	}



