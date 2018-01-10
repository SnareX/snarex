package de.hftstuttgart.snarex.model;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import de.hftstuttgart.snarex.datapoint.Datapoint;
import de.hftstuttgart.snarex.sensor.Sensor;

public class Model {

    /**
     * Vector containing all Sensor Objects
     */
    public Vector<Sensor> sensorVector = new Vector<>();
    public static BlockingQueue<Datapoint> dpQueue = new LinkedBlockingDeque<Datapoint>();

	/**
	 * adds a new Sensor to sensorVector;
	 */
	public void addSensor() {
		sensorVector.add(new Sensor());
	}

	/**
	 * connects to selected Sensor
	 * @param index the number of the element in Vector;
     *
	 */

	public void connectToSensor(int index) {
		sensorVector.elementAt(index).connect();
	}

	/**
	 * disconnects to selected Sensor;
	 * 
	 * @param index the number of the element in Vector
     *
	 */
	public void closeSensorConnection(int index) {
		sensorVector.elementAt(index).close();

	}

	public void insert() {

	}

	public void read() {

	}

	public void delete() {

	}

	public void connect() {

	}

	public static void main(String[] args) {
		Model model1 = new Model();
		model1.addSensor();

		model1.connectToSensor(0);
		// model1.closeSensorConnection(0);

	}

	public void createTable() {

	}

	public void close() {

	}

}
