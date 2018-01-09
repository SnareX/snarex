package de.hftstuttgart.snarex.sensor;

import de.hft.wiinf.cebarround.CeBarRoundDataSensorV2;
import de.hft.wiinf.cebarround.CeBarRoundObserver;
import de.hft.wiinf.cebarround.SensorEvent;

/**
 * Wrapper class around de.hft.wiinf.cebarround.CeBarRoundDataSensorV2;
 *  *
 */
public class Sensor{

    CeBarRoundDataSensorV2 cebarsensor = new CeBarRoundDataSensorV2();

    /**
     * basic constructor
     */
    public Sensor(){

    }
    public void connect(){
        /**
         * adds Listener and handles SensorEvents
         */
        cebarsensor.addListener(new CeBarRoundObserver<SensorEvent>() {

            @Override
            public void sensorDataEventListener(SensorEvent arg0) {
                System.out.println("Revolutions: " + arg0.getRevolutions());
            }



        });
        cebarsensor.startMeasure();
    }


    /**
     * closes connection and deletes all Listeners
     */
    public void close(){

        cebarsensor.stopMeasure();
    }
}
