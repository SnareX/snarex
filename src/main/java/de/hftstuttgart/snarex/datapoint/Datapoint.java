package de.hftstuttgart.snarex.datapoint;

import de.hft.wiinf.cebarround.SensorEvent;

import javax.xml.crypto.Data;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Datapoint {

    private double temperature;
    private double pressure;
    private double revolutions;
    private String sekunden;
    private int date;
    
    public Datapoint() {
        temperature = 0;
        pressure = 0;
        revolutions = 0;
        sekunden = null;
    };

    public Datapoint(SensorEvent sEvent){

        temperature = sEvent.getTemperature();
        pressure = sEvent.getPressure();
        revolutions = sEvent.getRevolutions();
        sekunden = sEvent.getDate().toString();
    }

	public Datapoint(double temperature, double pressure, double revolutions, String sekunden) { // ???
		this.temperature = temperature;
		this.pressure = pressure;
		this.revolutions = revolutions;
		this.sekunden = sekunden;
	}

	

	public String getSekunden() {
		return sekunden;
	}

	public void setSekunden(String sekunden) {
		this.sekunden = sekunden;
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
