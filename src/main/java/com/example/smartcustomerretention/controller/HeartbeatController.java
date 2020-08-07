package com.example.smartcustomerretention.controller;

import com.example.smartcustomerretention.models.Heartbeat;
import com.sun.istack.NotNull;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HeartbeatController {
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	// update the heartbeat table
	@PostMapping("/heartbeat")
	public String updateHeartbeat(@RequestBody Heartbeat heartbeat){
		HeartbeatController hc = new HeartbeatController();

		Heartbeat hb = readHeartbeat(heartbeat.getUserId());

		Session s = factory.openSession();
		Transaction tx = null;
		int id = hb.getId();
		int userId = heartbeat.getUserId();
		int week = heartbeat.getWeek() + hb.getWeek();
		int month = heartbeat.getMonth()+ hb.getMonth();
		int quarter = heartbeat.getQuarter()+ hb.getQuarter();
		int sixMonth = heartbeat.getSixMonth()+hb.getSixMonth();
		int year = heartbeat.getYear()+hb.getYear();
		String lastUpdated = "";

		// update the heartbeat table by adding the values
		// from the request to the existing values in the heartbeat table
		try{
			Heartbeat temp = new Heartbeat(id, userId, week, month, quarter, sixMonth, year, lastUpdated);
			lastUpdated = hb.currentTime();
			temp.setId(id);
			temp.setLastUpdatedTime(lastUpdated);
			tx = s.beginTransaction();
			s.update(temp);
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			System.out.println("Failed in updating db");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return "added to queue";
	}

	public Heartbeat readHeartbeat(int userId){

		Session s = factory.openSession();
		Transaction tx = null;
		Heartbeat heartbeat1 = null;

		// read the row for existing userid in heartbeat table
		try{
			tx = s.beginTransaction();
			String query = "Select * from heartbeat where userid = " + userId;
			heartbeat1 = s.get(Heartbeat.class, userId);

			tx.commit();
		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();

			System.out.println("Failed in reading db");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return heartbeat1;
	}

}
