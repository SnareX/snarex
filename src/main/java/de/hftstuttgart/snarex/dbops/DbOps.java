package de.hftstuttgart.snarex.dbops;

import de.hftstuttgart.snarex.datapoint.Datapoint;
import de.hftstuttgart.snarex.model.Model;

import static de.hftstuttgart.snarex.model.Model.dpQueue;

public class DbOps {

    void pushToDpQueue(Datapoint dp){

        //clear the queue in case any unwanted elements remain
        dpQueue.clear();

        synchronized (dpQueue) {

            //should always be true due to previous clear(),
            // but remains as a security measure
            if (!dpQueue.offer(dp)) {
                dpQueue.offer(dp);
            }

            //notify consumer
            dpQueue.notify();

        }
    }
}
