package de.hftstuttgart.snarex.model;

import de.hft.wiinf.cebarround.*;

public class Model {
	
	public CeBarRoundDataSensorV2 sensor1 = new CeBarRoundDataSensorV2();
	private CeBarRoundEvent event1 = null;

	public void insert() {

	}

	public void read() {

	}
	

	public void delete() {

	}

	public void connect() {
		sensor1.startMeasure();
		sensor1.addListener(new CeBarRoundObserver<SensorEvent>() {

			@Override
			public void sensorDataEventListener(SensorEvent arg0) {
				System.out.println("Revolutions: " + arg0.getRevolutions());

				
			}

		});


	}

	public void createTable() {

	}

	public void close() {
		sensor1.stopMeasure();

	}
	public static void main(String[] args){
		Model model1 = new Model();
		model1.connect();// TODO Auto-generated method stub
	}

}
