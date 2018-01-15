package de.hftstuttgart.snarex.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import de.hftstuttgart.snarex.datapoint.Datapoint;
import de.hftstuttgart.snarex.datapoint.DpConsumer;
import de.hftstuttgart.snarex.dbops.DbOps;
import de.hftstuttgart.snarex.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controller {

	@FXML
	private Label sensorSelectionLbl;
	
	@FXML
	private Label dataBaseLbl;

	@FXML
	private Label alertsLbl;

	@FXML
	private Label measuringLbl;

	@FXML
	private Label recordLbl;

	@FXML
	private Label tempColorLbl;

	@FXML
	private Label pressColorLbl;

	@FXML
	private Label rotColorLbl;

	@FXML
	private ComboBox<?> databaseComboBox;

	@FXML
	private ComboBox<?> sensorComboBox;

	@FXML
	private ComboBox<?> alertComboBox;

	@FXML
	private ComboBox<?> inputTypeComboBox;

	@FXML
	private ComboBox<?> barTypeComboBox;

	@FXML
	private ComboBox<?> inputInComboBox;

	@FXML
	private Button startMeasuringBtn;

	@FXML
	private Button stopMeasuringBtn;

	@FXML
	public Button startRecordBtn;

	@FXML
	private Button stopRecordBtn;

	@FXML
	private Button showRecordedBtn;

	@FXML
	private Button compareBtn;

	@FXML
	private Button clearChartBtn;

	@FXML
	private ColorPicker tempColorPicker;

	@FXML
	private ColorPicker pressColorPicker;

	@FXML
	private ColorPicker rotColorPicker;

	@FXML
	private MenuBar menuBar;

	@FXML
	private MenuBar questionMark;

	@FXML
	private MenuItem helpItem;

	@FXML
	private ContextMenu contextMenu;

	@FXML
	private Menu menuSensor;

	@FXML
	private Menu menuDatabase;

	@FXML
	private Menu menuAlert;

	@FXML
	private Menu openDataItem;

	@FXML
	private Menu deleteDataItem;
	
	@FXML
	private Menu setVisibleMenu;
	
	@FXML
	private Menu setInvisibleMenu;
	
	@FXML
	private MenuItem setInvisibleMenuItem;
	
	@FXML
	private MenuItem setVisibleMenuItem;
	
	@FXML
	private MenuItem openDataSubItem;
	
	@FXML
	private MenuItem deleteDataSubItem;


	@FXML
	private MenuItem sensorAdd;

	@FXML
	private MenuItem sensorDelete;

	@FXML
	private MenuItem databaseAdd;

	@FXML
	private MenuItem databaseDelete;

	@FXML
	private MenuItem alertAdd;

	@FXML
	private MenuItem alertDelete;

	@FXML
	private MenuItem manualItem;

	@FXML
	private MenuItem supportItem;

	// made public to fix chart issues
	@FXML
	public LineChart<?, ?> pressureChart;

	@FXML
	public LineChart<?, ?> temperatureChart;

	@FXML
	public LineChart<?, ?> rotationsChart;

	@FXML
	private TreeView<?> treeTree;

	@FXML
	private TreeItem<?> rootTree;

	@FXML
	private TreeItem<?> sensorTree;

	@FXML
	private TreeItem<?> sensor_01;

	@FXML
	private TreeItem<?> sensor_02;

	@FXML
	private TreeItem<?> dataTree;

	@FXML
	private TreeItem<?> databaseTree;

	@FXML
	private TreeItem<?> alertTree;

	@FXML
	private TreeItem<?> pressureAlTree;

	@FXML
	private TreeItem<?> pressurexAlTree;

	@FXML
	private TreeItem<?> pressureyAlTree;

	@FXML
	private TreeItem<?> tempAlTree;

	@FXML
	private TreeItem<?> tempxAlTree;

	@FXML
	private TreeItem<?> tempyAlTree;

	@FXML
	private TreeItem<?> revAlTree;

	@FXML
	private TreeItem<?> revxAlTree;

	@FXML
	private TreeItem<?> revyAlTree;

	@FXML
	void startMeasureClick(ActionEvent event) {

		System.out.println("event fired");
		String[] crap = new String[1];
		Model.main(crap);
		// graphPlotter(new Datapoint());
	}

	@FXML
	void compareClick(ActionEvent event) {

	}

	@FXML
	void clearChartClick(ActionEvent event) {

		// zugriff auf andere buttons wahrend des clearens verweigern muss hinzugefugt
		// werden
		temperatureChart.getData().get(0).getData().clear();
		pressureChart.getData().get(0).getData().clear();
		rotationsChart.getData().get(0).getData().clear();
		rotationsChart.getData().clear();
		pressureChart.getData().clear();
		temperatureChart.getData().clear();
	}

	@FXML
	void setVisibleMenuItemClicked(ActionEvent event) {
		
		treeTree.setVisible(true);
		
	}
	
	@FXML
	void setInvisibleMenuItemClicked(ActionEvent event) {
		
		treeTree.setVisible(false);
		
	}
	
	@FXML
	void openDataSubItemClicked(ActionEvent event) {
		//Method to load data from database
	}

	@FXML
	void deleteDataSubItemClicked(ActionEvent event) {
		//Method to delete data from database
	}
	
	@FXML
	void selectBarTypeSelect(ActionEvent event) {

	}

	@FXML
	void selectDatabaseSelect(ActionEvent event) {

	}

	@FXML
	void selectInputTypeSelect(ActionEvent event) {

	}

	@FXML
	void selectSensorSelect(ActionEvent event) {

	}

	@FXML
	void showInputInSelect(ActionEvent event) {

	}

	@FXML
	void showRecordedClick(ActionEvent event) {

	}

	@FXML
	void startRecordClick(ActionEvent event) {
		// start reading data from cebarround and save into arraylist as cache
		Model.saving = true;
	}

	@FXML
	void stopMeasureClick(ActionEvent event) {

		Model.closeSensorConnection(0);

	}

	@FXML
	void stopRecordClick(ActionEvent event) {

		// stop reading data from cebarround and ask for record name
		// start saving from arraylist into database with value recordName
		
		Model.saving = false;
		
//		window pop up (" do you want to save your record?")
//		if(speichern) {
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		open window
//		String recordName = scanner.nextLine();
		 for(Datapoint dtp : Model.dpList ) {
			DbOps.saveData(dtp," ");
		 }
		
//     }else	
		Model.dpList.clear();
//	   }
	}

	@FXML
	void alertAddClick(ActionEvent event) {

	}

	@FXML
	void alertDeleteClick(ActionEvent event) {

	}

	@FXML
	void databaseAddClick(ActionEvent event) {

	}

	@FXML
	void databaseDeleteClick(ActionEvent event) {

	}

	@FXML
	void sensorAddClick(ActionEvent event) {

	}

	@FXML
	void helpItemClicked(ActionEvent event) {

		try {
			Desktop.getDesktop().browse(new URL("https://github.com/SnareX/snarex/wiki/Support-homepage").toURI());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void supportItemClicked(ActionEvent event) {

		try {
			Desktop.getDesktop().browse(new URL("https://github.com/SnareX/snarex/wiki/Support-homepage").toURI());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void manualItemClicked(ActionEvent event) {

		try {
			Desktop.getDesktop().browse(new URL("https://github.com/SnareX/snarex/wiki/Benutzerhandbuch").toURI());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void sensorDeleteClick(ActionEvent event) {

	}

	public void colorPickerTemperatureSelect(ActionEvent actionEvent) {
		pressureChart.setStyle("#pressureValues {-fx-bar-fill: " + pressColorPicker.getValue().toString() + " }");
	}

	public void colorPickerPressureSelect(ActionEvent actionEvent) {

	}

	public void colorPickerRevolutionsSelect(ActionEvent actionEvent) {

	}
}
