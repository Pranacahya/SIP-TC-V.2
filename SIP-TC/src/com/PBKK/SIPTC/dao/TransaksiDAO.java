package com.PBKK.SIPTC.dao;

import com.PBKK.SIPTC.entity.User;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartFile;

public interface TransaksiDAO {
	public List<User> getUsers();	
	public void pushUser(String user,String nrp,
							MultipartFile file,
							String copies, 
							String pages, 
							String color,
							String paper,
							String side,
							String note) ;
}
