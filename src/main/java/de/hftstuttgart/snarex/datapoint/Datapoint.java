package de.hftstuttgart.snarex.datapoint;

import de.hft.wiinf.cebarround.SensorEvent;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Datapoint {

    private double temperature;
    private double pressure;
    private double revolutions;
    
    public Datapoint() {
        temperature = 0;
        pressure = 0;
        revolutions = 0;
    };

    public Datapoint(SensorEvent sEvent){

        temperature = sEvent.getTemperature();
        pressure = sEvent.getPressure();
        revolutions = sEvent.getRevolutions();
    }

	public Datapoint(double temperature, double pressure, double revolutions) { // ???
		this.temperature = temperature;
		this.pressure = pressure;
		this.revolutions = revolutions;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getRevolutions() {
		return revolutions;
	}

	public void setRevolutions(double revolutions) {
		this.revolutions = revolutions;
	}

	public double getTemperature() {

		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
