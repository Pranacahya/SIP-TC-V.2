package com.PBKK.SIPTC.dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.PBKK.SIPTC.controller.PathFile;
import com.PBKK.SIPTC.entity.Transaksi;
import com.PBKK.SIPTC.entity.User;
import com.PBKK.SIPTC.entity.User;

@Component
public class TransaksiDAOImpl implements TransaksiDAO {

	@Override
	public List<User> getUsers() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pushUser(String user,String nrp,
			MultipartFile file,
			String copies, 
			String pages, 
			String color,
			String paper,
			String side,
			String note) {
		String myPath = System.getProperty("user.dir")+"/upload";
		if(pages.length() <= 3)
		{
			pages = "full-pages";
		}
		else
		{
			pages = pages.replace("on,","");
		}
		if(copies.length()==0)
		{
			copies = "1";
		}
		System.out.println(file);
		System.out.println(copies);
		System.out.println(pages);
		System.out.println(color);
		System.out.println(paper);
		System.out.println(side);
		System.out.println(note);
		String notes = copies +"| "+ pages+"| "+color +"| "+paper+"| " +side +"| " + note;
		File dirPath = new File(myPath);
		if (!dirPath.exists()) 
		{
	        dirPath.mkdirs();     
		}
		String myFile = dirPath+"/"+file.getOriginalFilename();
		System.out.println(myFile);
		File filePath = new File(myFile);
		try {
			file.transferTo(filePath);
			System.out.println("transfered");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String timeStamp[];
		timeStamp = dateFormat.format(date).split(" ");
		String tanggal = timeStamp[0];
		String time = timeStamp[1];
//		System.out.println(file); //2016/11/16 12:08:43
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Transaksi.class)
				.buildSessionFactory();
		
		// Begin Transaction
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// Create object
		Transaksi trans = new Transaksi(2,tanggal,time,user,nrp,notes,myFile.toString(),0);
				
		// Save object to database 
		session.save(trans);
		
		//Read data
		Transaksi tempTrans = session.get(Transaksi.class, trans.getId());
		System.out.println(tempTrans.getId());
		
		// Commit transaction
		session.getTransaction().commit();
		System.out.println("Committing transaction.");
				
		// Close transaction
		session.close();
		System.out.println("Session closed.");
				
		
		SessionFactory factory2 = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(PathFile.class)
						.buildSessionFactory();
		
		// Transaksi simpan path
		Session session2 = factory2.getCurrentSession();
		session2.beginTransaction();
		// TODO Auto-generated method stub
		
	}


}
