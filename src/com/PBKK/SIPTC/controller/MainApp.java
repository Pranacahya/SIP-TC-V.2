package com.PBKK.SIPTC.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.PBKK.SIPTC.entity.Transaksi;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Transaksi.class)
				.buildSessionFactory();
		
		// Begin Transaction
				Session session = factory.getCurrentSession();
				session.beginTransaction();
				
				// Create object
				
				
				// Save object to database 
	
				
				// Commit transaction
				session.getTransaction().commit();
				System.out.println("Committing transaction.");
				
				// Close transaction
				session.close();
				System.out.println("Session closed.");
	}

}
