package de.hftstuttgart.snarex.sensor;

import de.hft.wiinf.cebarround.*;
import de.hftstuttgart.snarex.datapoint.Datapoint;

/**
 * Wrapper class around de.hft.wiinf.cebarround.CeBarRoundDataSensorV2;
 *
 */
public class Sensor {

	private CeBarRoundDataSensorV2 cebarsensor = new CeBarRoundDataSensorV2();

	/**
	 * basic constructor;
	 */
	public Sensor() {

	}

	/**
	 * adds Listener and handles SensorEvents;
	 */
	public void connect() {
		cebarsensor.addListener(new CeBarRoundObserver<SensorEvent>() {

			@Override
			public void sensorDataEventListener(SensorEvent sEvent) {
				Datapoint dp = new Datapoint(sEvent.getTemperature(), sEvent.getPressure(), sEvent.getRevolutions());
				// deliver to Database / Database queue
				// deliver to Plot in view
			}
		});

		cebarsensor.startMeasure();
	}

	/**
	 * closes connection and deletes all Listeners;
	 */
	public void close() {
		cebarsensor.stopMeasure();
	}
}
