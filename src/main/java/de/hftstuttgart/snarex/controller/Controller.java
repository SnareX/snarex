package de.hftstuttgart.snarex.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

public class Controller {

    @FXML
    private Label sensorSelectionLbl;

    @FXML
    private Label dataBaseLbl;

    @FXML
    private ComboBox<?> databaseComboBox;

    @FXML
    private ComboBox<?> sensorComboBox;

    @FXML
    private Label alertsLbl;

    @FXML
    private ComboBox<?> alertComboBox;

    @FXML
    private Label measuringLbl;

    @FXML
    private Button startMeasuringBtn;

    @FXML
    private Button stopMeasuringBtn;

    @FXML
    private Label recordLbl;

    @FXML
    private Button startRecordBtn;

    @FXML
    private Button stopRecordBtn;

    @FXML
    private Button showRecordedBtn;

    @FXML
    private ColorPicker tempColorPicker;

    @FXML
    private ColorPicker pressColorPicker;

    @FXML
    private ColorPicker rotColorPicker;

    @FXML
    private Label tempColorLbl;

    @FXML
    private Label pressColorLbl;

    @FXML
    private Label rotColorLbl;

    @FXML
    private ComboBox<?> inputTypeComboBox;

    @FXML
    private ComboBox<?> barTypeComboBox;

    @FXML
    private ComboBox<?> inputInComboBox;

    @FXML
    private Button compareBtn;

    @FXML
    private MenuBar menuBar;

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

}
