package de.hftstuttgart.snarex.dbops;

import org.hibernate.sql.ordering.antlr.Factory;

import de.hftstuttgart.snarex.dbops.*;

public class DbOpsTest {

	public static void main(String[] args) {
		try{
			DbOps.getConnectionDb();
		}finally {
			DbOps.factory.close();
		}
	}

}
