package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FxView extends Application {

	private Label lbl1 = new Label("Eingabe: ");
	private TextField txtEingabe = new TextField("   ");
	 Button cmdCalc = new Button("Snarex berechnen");
	private TextField txtErg = new TextField("     ");
	private Button cmdClear = new Button("Zuruecksetzen");

	
	
	
	public void startView () {
		
		launch();
	}

	public void start(Stage FXViewStage)throws Exception {

		
		HBox root = new HBox();
		
		root.getChildren().addAll(lbl1, txtEingabe, cmdCalc, txtErg, cmdClear);
		
		Scene scene = new Scene(root, 600, 100);
		
		FXViewStage.setScene(scene);
		
		FXViewStage.show();

		FXViewStage.setTitle("Snarex");
	}
	
	 public void resetView(){
	        this.txtEingabe.setText("");
	        this.txtErg.setText("");
	    }

	    public String getEingabe(){
	        return this.txtEingabe.getText();
	    }

	    public void setErgebnis(String erg){
	        this.txtErg.setText(erg);
	    }

	   
	    public void setSnarexBerechnenListener(EventHandler<ActionEvent> l ){
	        this.cmdCalc.setOnAction(l);;
	    }

	    public void setResetFormListener(EventHandler<ActionEvent> l){
	        this.cmdClear.setOnAction(l);
	    }

}
