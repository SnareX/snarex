package de.hftstuttgart.snarex.model;

import java.util.Vector;
import de.hftstuttgart.snarex.sensor.Sensor;

public class Model {

    /**
     * Vector containing all Sensor Objects
     */
    public Vector<Sensor> sensorVector = new Vector<>();

	public void addSensor(){
	    sensorVector.add(new Sensor());
    }

    public void connectToSensor(int index){

	    sensorVector.elementAt(index).connect();
    }

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
		//model1.closeSensorConnection(0);

	}
	public void createTable() {

	}

	public void close() {

	}

}
