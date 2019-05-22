package com.PBKK.SIPTC.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	static String uploadPath = System.getProperty("user.dir")+"/uploads";
	ServletContext context;
	String myName;
	String myNrp;
	ArrayList<Queue> antri = new ArrayList<Queue>();
	
	@RequestMapping("/")
	public String showHome()
	{
		return "menu";
	}
	
	@RequestMapping(value="/learn")
	public String showLearn()
	{
		
		return "learn";
	}
	
	@RequestMapping(value = "/learnProses", method = RequestMethod.POST)
	public String processForm(@RequestParam("file") MultipartFile file, ModelMap modelMap)
	{	
		String myPath = System.getProperty("user.dir")+"/upload";
		File dirPath = new File(myPath);
		if (!dirPath.exists()) 
		{
	        dirPath.mkdirs();     
		}
		String myFile = dirPath+"/"+file.getOriginalFilename();
		File filePath = new File(myFile);
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(filePath);
			System.out.println("transfered");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String relativeWebPath = "/resources/file";
//		String absoluteFilePath = context.getRealPath(relativeWebPath);		
		
//		File uploadedFile = new File(absoluteFilePath, "your file name");
		modelMap.addAttribute("file", file);
		return "fileCatch";
	}
	
	@RequestMapping("/admin")
	public String show()
	{
		return "dashboard_admin";
	}
	
	@RequestMapping("/pesan")
	public String showPesan(Model model)
	{			
//		model.addAttribute("personalData", myName);
		System.out.println(myName);		
		System.out.println(myNrp);	
		model.addAttribute("myName", myName);
		if(antri.size() > 0)
		{
			for(Queue data : antri)
			{
				System.out.println(data.getName());
			}			
		}
		
//		model.addAttribute("nrp",myNrp);
//		Admin myAdmin = new Admin(myName, myNrp);
//		String type2 = request.getParameter("whistle");
//		String type3 = request.getParameter("eaves");
//		int stat = 0;
//		int stat2 = 0;
//		int stat3 = 0;
//		if(type!=null)
//			if(type.equals("1"))
//			{
//				types = "Assassin";
//				stat = 1;
//			}
//				
//				
//		if(type2!=null)
//			if(type2.equals("1"))
//			{
//				types = types + ", Whistle Blower";
//				stat2 = 1;
//			}
//				
//		if(type3!=null)
//			if(type3.equals("1"))
//			{
//				types = types + ", EavesDropper";
//				stat3 = 1;
//			}
//				
//		if(types == null)
//		{
//			types = "The Noobs";
//		}
//		model.addAttribute("types", types);
//		model.addAttribute("jobs1",stat);
//		model.addAttribute("jobs2",stat2);
//		model.addAttribute("jobs3",stat3);
		return "print";
	}
	
	@RequestMapping("/fetch")
	public String processFetch(
			@RequestParam("studentsName") String name,
			@RequestParam("nrp") String nrp,
			Model model)
	{
		myName = name;
		myNrp = nrp;
		return "FetchingData";
	}
	
	@RequestMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	
	@RequestMapping("/kirim")
	public String showKirim(Model model)
	{
		model.addAttribute("myName", myName);
		return "Kirim";
	}
	
	@RequestMapping("/prosesKirim")
	public String processKirim()
	{
		antri.add(new Queue(myName, myNrp, "file"));
		return "prosesKirim";
	}
	@RequestMapping("/upload")
	public String showUpload()
	{
		return "";
	}
}
