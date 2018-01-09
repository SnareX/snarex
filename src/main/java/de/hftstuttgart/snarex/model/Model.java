package de.hftstuttgart.snarex.model;

import de.hft.wiinf.cebarround.*;
import de.hftstuttgart.snarex.sensor.Sensor;

import java.util.Vector;

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

	public void createTable() {

	}



	public static void main(String[] args){
		Model model1 = new Model();
		model1.addSensor();

		model1.connectToSensor(0);
		//model1.closeSensorConnection(0);
	}

}
