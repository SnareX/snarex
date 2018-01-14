package de.hftstuttgart.snarex.dbops;

public class DbOpsTest {

	public static void main(String[] args) {
		try{
			DbOps.getConnectionDb();
		}finally {
			DbOps.factory.close();
		}
	}

}
