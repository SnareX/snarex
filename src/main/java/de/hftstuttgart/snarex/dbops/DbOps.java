package de.hftstuttgart.snarex.dbops;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbOps {
	static SessionFactory factory;
	
	public static void getConnection() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println("SessionFactory object created successfully. Connection to database is up.");
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}
}
