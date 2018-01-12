package de.hftstuttgart.snarex.datapoint;

import de.hftstuttgart.snarex.controller.Controller;
import de.hftstuttgart.snarex.model.Model;
import javafx.scene.chart.XYChart;

public class DpConsumer extends Thread{

    public DpConsumer(){
        System.out.println("dpc created");
    }
    @Override
    public void run(){
        try{
            System.out.println("dpc running");
            synchronized (Model.dpQueue){
                if(!isInterrupted()) {
                    if (Model.dpQueue.isEmpty()) {

                            Model.dpQueue.wait();
                        }
                    }

                Datapoint dp = Model.dpQueue.take();
                graphPlotter(dp);

            }
        }
        catch(InterruptedException e){
            interrupt();
            System.out.println(this.getClass().toString() + "was interrupted");
        }

    }
    public static void graphPlotter (Datapoint datapoint) {
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series_1 = new XYChart.Series();
        XYChart.Series series_2 = new XYChart.Series();
        series_1.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getPressure()));
        series_2.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getRevolutions()));
        series.getData().add(new XYChart.Data<>(datapoint.getSekunden(), datapoint.getTemperature()));
        Controller.pressureChart.getData().addAll(series_1);
        Controller.temperatureChart.getData().addAll(series);
        Controller.rotationsChart.getData().addAll(series_2);
    }


}
