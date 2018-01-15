package de.hftstuttgart.snarex.launcher;

import de.hftstuttgart.snarex.controller.Controller;
import de.hftstuttgart.snarex.datapoint.DpConsumer;
import de.hftstuttgart.snarex.dbops.DbOps;
import de.hftstuttgart.snarex.model.Model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

import org.hibernate.sql.ordering.antlr.Factory;


public class Launcher extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {


			//connect fxmlloader to fxml file, using the preferred non-static method
			URL location = Controller.class.getResource("/de/hftstuttgart/snarex/view/View5.fxml"); //beginning with slash to imply from project root
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(location);
			
			primaryStage.setOnCloseRequest(e -> {
				Platform.exit();
				System.exit(0);
				DbOps.factory.close();
			
			});

			//get root / outer pane
			BorderPane outerPane = (BorderPane) loader.load();

			//get Controller object and associate it with DatapointConsumer, start DatapointConsumer Thread
			Controller c = loader.getController();
			DpConsumer dpc = new DpConsumer();
			dpc.associateController(c);
			dpc.start();

			// set up connection to db
			DbOps.getConnectionDb();
						
			//set up the scene
			primaryStage.setScene(new Scene(outerPane));
			primaryStage.setTitle("Snarex");
			primaryStage.show();
			
			

			
		}
		
		public static void main (String[]args) {
			launch(args);
		}

	}



