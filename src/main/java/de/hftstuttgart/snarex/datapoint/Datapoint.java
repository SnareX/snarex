package de.hftstuttgart.snarex.datapoint;

import de.hft.wiinf.cebarround.SensorEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datapoint {

	private int id;
	private double temperature;
	private double pressure;
	private double revolutions;
	private String uhrzeit;
	private LocalDateTime date;
	String recordName;

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public Datapoint() {
	};

	public Datapoint(SensorEvent sEvent) {
		this.date = LocalDateTime.now();
		this.temperature = sEvent.getTemperature();
		this.pressure = sEvent.getPressure();
		this.revolutions = sEvent.getRevolutions();
		this.uhrzeit = date.format(formatter);
	}
	
	/* Constructor: saving into database */
	public Datapoint(double temperature, double pressure, double revolutions, String recordName) {
		this.date = LocalDateTime.now();
		this.temperature = temperature;
		this.pressure = pressure;
		this.revolutions = revolutions;
		this.recordName = recordName;
	}

	/* Constructor: saving into XYChart */
	public Datapoint(double temperature, double pressure, double revolutions) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.revolutions = revolutions;
		this.date = LocalDateTime.now();
		this.uhrzeit = date.format(formatter);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getSekunden() {
		return uhrzeit;
	}

	public void setSekunden(String sekunden) {
		this.uhrzeit = sekunden;
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

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
	
	
}
