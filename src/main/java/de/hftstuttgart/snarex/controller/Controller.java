package de.hftstuttgart.snarex.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controller implements Initializable {

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
    private Button startRecordBtn;

    @FXML
    private Button stopRecordBtn;

    @FXML
    private Button showRecordedBtn;
    
    @FXML
    private Button compareBtn;

    @FXML
    private ColorPicker tempColorPicker;

    @FXML
    private ColorPicker pressColorPicker;

    @FXML
    private ColorPicker rotColorPicker;

    @FXML
    private MenuBar menuBar;
    
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
    private LineChart<?, ?> pressureChart;

    @FXML
    private LineChart<?, ?> temperatureChart;

    @FXML
    private LineChart<?, ?> rotationsChart;

    @FXML
    void compareClick(ActionEvent event) {

    }

    @FXML
    void selectAlertsSelect(ActionEvent event) {

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
    void startMeasureClick(ActionEvent event) {

    }

    @FXML
    void startRecordClick(ActionEvent event) {

    }

    @FXML
    void stopMeasureClick(ActionEvent event) {

    }

    @FXML
    void stopRecordClick(ActionEvent event) {

    }
 
public void graphPlotter (String valueNumber, double pressure, double revolutions, double temperature) {
	XYChart.Series series = new XYChart.Series();
	XYChart.Series series_1 = new XYChart.Series();
	XYChart.Series series_2 = new XYChart.Series();
	series_1.getData().add(new XYChart.Data<>(valueNumber, pressure));
	series_2.getData().add(new XYChart.Data<>(valueNumber, revolutions));
	series.getData().add(new XYChart.Data<>(valueNumber, temperature));
	
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	XYChart.Series series = new XYChart.Series();
	series.getData().add(new XYChart.Data<>("1", 23));
	series.getData().add(new XYChart.Data<>("23", 120));
	series.getData().add(new XYChart.Data<>("55", 100));
	pressureChart.getData().addAll(series);
	
		
	}

}
