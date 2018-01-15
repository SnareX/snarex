package de.hftstuttgart.snarex.dbops;

import java.util.List;

import de.hftstuttgart.snarex.datapoint.*;

public class DbOpsTest {

	public static void main(String[] args) {
		try{
			DbOps.getConnectionDb();
			
//			Datapoint dtp = new Datapoint(36.2,2.2,8000.1);
//			DbOps.saveData(dtp,"Adrian");
			
			List<Datapoint> datapoints = DbOps.getData("Adrian");
			for(Datapoint dtp : datapoints) {
				System.out.println(dtp.getId() + " "+dtp.getDate()+" "+dtp.getTemperature()+" "+dtp.getPressure()+" "+dtp.getRevolutions()+ " "+dtp.getRecordName());
			}
			
		}finally {
			DbOps.factory.close();
		}
	}

}
