package de.hftstuttgart.snarex.dbops;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import de.hftstuttgart.snarex.datapoint.Datapoint;
import de.hftstuttgart.snarex.model.Model;

import static de.hftstuttgart.snarex.model.Model.dpQueue;

import java.util.List;

public class DbOps {
	

	public static SessionFactory factory;
	
	/* create Connection to Database */
	public static void getConnectionDb() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println("SessionFactory object created successfully. Connection to database is up.");
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	/* save Datapoint object into database*/
	public static void saveData(Datapoint datapoint,String recordName) {
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			datapoint.setRecordName(recordName);
			session.save(datapoint);
			session.getTransaction().commit();
			System.out.println("Successfully saved");
			session.close();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	/* delete data from table DATAPOINTS with recordName */
	public static void deleteData(String recordName) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.createQuery("delete from Datapoint where recordName ="+recordName).executeUpdate();
		session.getTransaction().commit();
		System.out.println("Successfully deleted");
		session.close();
	}
	
	/* get data from database in a list */
	public static List<Datapoint> getData(String recordName){
		List <Datapoint> datapoints;
		Session session = factory.openSession();
		datapoints = session.createQuery("From Datapoint where recordName ="+recordName).list();
		session.close();
		return datapoints;
	}
	
	
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
