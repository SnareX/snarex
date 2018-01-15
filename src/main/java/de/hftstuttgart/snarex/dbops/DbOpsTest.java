package de.hftstuttgart.snarex.dbops;

import java.util.List;

import de.hftstuttgart.snarex.datapoint.*;

public class DbOpsTest {

	public static void main(String[] args) {
		try{
			// connect to database
			DbOps.getConnectionDb();
			
			// create new object
//			Datapoint dtp = new Datapoint(36.2,2.2,8000.1);
//			DbOps.saveData(dtp,"Adrian");
			
			// delete data
			//DbOps.deleteData("Adrian");
			
			//read from database
			List<Datapoint> datapoints = DbOps.getData("Adrian");
			for(Datapoint dtpt : datapoints) {
				System.out.println(dtpt.getId() + " "+dtpt.getDate()+" "+dtpt.getTemperature()+" "+dtpt.getPressure()+" "+dtpt.getRevolutions()+ " "+dtpt.getRecordName());
			}
			
			
			
		}finally {
			DbOps.factory.close();
		}
	}

}
