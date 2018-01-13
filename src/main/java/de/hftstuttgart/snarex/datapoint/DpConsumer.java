package de.hftstuttgart.snarex.datapoint;

import de.hftstuttgart.snarex.controller.Controller;
import de.hftstuttgart.snarex.launcher.Launcher;
import de.hftstuttgart.snarex.model.Model;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

public class DpConsumer extends Thread{

    @FXML
    private Controller controller;

    public void initialize(){
        if (controller != null){
            System.out.println("Controller is available");
        }

    }
    public DpConsumer(){
        System.out.println("dpc created");

    }
    @Override
    public void run(){
        try{
            this.initialize();
            System.out.println("dpc running");
            synchronized (Model.dpQueue){
                while(!isInterrupted()) {
                    if (Model.dpQueue.isEmpty()) {
                        Model.dpQueue.wait();
                        }

                Datapoint dp = Model.dpQueue.take();
                graphPlotter(dp);
                }
            }
        }
        catch(InterruptedException e){
            interrupt();
            System.out.println(this.getClass().toString() + "was interrupted");
        }

    }
    public void graphPlotter (Datapoint datapoint) {
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series_1 = new XYChart.Series();
        XYChart.Series series_2 = new XYChart.Series();
        System.out.println(datapoint.getSekunden() + "  " + Double.toString(datapoint.getPressure()));

        if(series != null){
            if(series.getData() == null){
                System.out.println("Data == null");
            }
            if(datapoint.getSekunden() == null){
                System.out.println("Sekunden == null");
            }
//            if(datapoint.getTemperature()== null){
//                System.out.println("Temperatur == null");
//            }
        }

        series.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getTemperature()));
        series_1.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getPressure()));
        series_2.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getRevolutions()));



        controller.temperatureChart.getData().addAll(series);
        controller.pressureChart.getData().addAll(series_1);
        controller.rotationsChart.getData().addAll(series_2);

        //XYChart.Series seriesArr[] = {series, series_1, series_2};
        //Launcher.c.finalPlotter(seriesArr);
    }


}
