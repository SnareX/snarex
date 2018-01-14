package de.hftstuttgart.snarex.datapoint;

import java.util.Iterator;

import de.hftstuttgart.snarex.controller.Controller;
import de.hftstuttgart.snarex.launcher.Launcher;
import de.hftstuttgart.snarex.model.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

/**
 *
 * This Thread consumes datapoints from dpQueue, computes them and passes them
 * to JavaFx Thread
 */
public class DpConsumer extends Thread {

	private Controller controller;

	public DpConsumer() {
		System.out.println("dpc created");

	}

	@Override
	public void run() {
		try {
			System.out.println("dpc running");
			synchronized (Model.dpQueue) {
				while (!isInterrupted()) {
					if (Model.dpQueue.isEmpty()) {
						Model.dpQueue.wait();
					}

					Datapoint dp = Model.dpQueue.take();
					graphPlotter(dp);
				}
			}
		} catch (InterruptedException e) {
			interrupt();
			System.out.println(this.getClass().toString() + "was interrupted");
		}

	}

	// associates the JavaFX Controller with the Consumer.
	// Controller instance is created in Launcher.java
	public void associateController(Controller c) {
		this.controller = c;
	}

	// create new XYChart.series objects
	XYChart.Series series = new XYChart.Series();
	XYChart.Series series_1 = new XYChart.Series();
	XYChart.Series series_2 = new XYChart.Series();

	// turns data into XYChart.series objects and passes those to JavaFx Thread
	public void graphPlotter(Datapoint datapoint) {

		// adds series only 1 time, so there won't be an exception

		if (series.getData().size() == 0) {

			// Sys Out to prove this stuff is working
			System.out.println(datapoint.getSekunden() + "  " + Double.toString(datapoint.getPressure()));

			// add new data from datapoint to series objects
			series.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getTemperature()));
			series_1.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getPressure()));
			series_2.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getRevolutions()));

			// passes modification in UI to JavaFX Thread
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					controller.temperatureChart.getData().add(series);
					controller.temperatureChart.setCreateSymbols(false);
					controller.pressureChart.getData().add(series_1);
					controller.pressureChart.setCreateSymbols(false);
					controller.rotationsChart.getData().add(series_2);
					controller.rotationsChart.setCreateSymbols(false);

				}
			});

		}

		else {

			// graph continues growing until 30 measurments are reached

			if (series.getData().size() < 30) {

				// add new data from datapoint to series objects
				series.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getTemperature()));
				series_1.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getPressure()));
				series_2.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getRevolutions()));
			}

			// a measurment gets added while the first measurment gets deleted, so the graph
			// doesn't get to tight

			else {

				series.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getTemperature()));
				series_1.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getPressure()));
				series_2.getData().add(new XYChart.Data<String, Double>(datapoint.getSekunden(), datapoint.getRevolutions()));

				series.getData().remove(0);
				series_1.getData().remove(0);
				series_2.getData().remove(0);

			}
		}
	}
}
