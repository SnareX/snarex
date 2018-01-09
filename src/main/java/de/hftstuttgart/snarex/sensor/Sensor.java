package de.hftstuttgart.snarex.sensor;

import de.hft.wiinf.cebarround.CeBarRoundDataSensorV2;
import de.hft.wiinf.cebarround.CeBarRoundObserver;
import de.hft.wiinf.cebarround.SensorEvent;
import de.hftstuttgart.snarex.datapoint.Datapoint;

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
            public void sensorDataEventListener(SensorEvent sEvent) {
                Datapoint dp = new Datapoint(sEvent);
                //deliver to Database / Database queue
                //deliver to Plot in view
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
