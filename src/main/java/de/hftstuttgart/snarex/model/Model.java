package de.hftstuttgart.snarex.model;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import de.hftstuttgart.snarex.datapoint.Datapoint;
import de.hftstuttgart.snarex.datapoint.DpConsumer;
import de.hftstuttgart.snarex.sensor.Sensor;
import javafx.application.Platform;

import static java.lang.Thread.sleep;

public class Model {
    /**
     * Vector containing all Sensor Objects
     */
    public static Vector<Sensor> sensorVector = new Vector<>();

    //queue for multithreaded chart updates
    public static BlockingQueue<Datapoint> dpQueue = new LinkedBlockingDeque<Datapoint>();

    //list for saving datapoints to the database. no multithreading required
    public static ArrayList<Datapoint> dpList = new ArrayList<>();

    //specifies whether to save to dpList for database operations or not
    public static boolean saving=false;
    
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
	public static void closeSensorConnection(int index) {
		sensorVector.elementAt(index).close();

	}


	public static void main(String[] args) {
		Model model1 = new Model();
		model1.addSensor();

		System.out.println("connecting to sensor...");
		model1.connectToSensor(0);

	}
}
