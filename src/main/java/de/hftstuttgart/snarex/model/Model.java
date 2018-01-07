package de.hftstuttgart.snarex.model;

import de.hft.wiinf.cebarround.*;

public class Model {
	
	private CeBarRoundDataSensorV2 sensor1 = new CeBarRoundDataSensorV2();
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
				// TODO Auto-generated method stub
				
			}
		});

	}

	public void createTable() {

	}

	public void close() {
		sensor1.stopMeasure();

	}

}
