package com.PBKK.SIPTC.controller;

public class Queue {
	String name;
	String nrp;
	String price;
	String file;
	
	public Queue() 
	{
		this.price = null;
	}
	public Queue(String name, String nrp, String file)
	{
		this.name = name;
		this.nrp = nrp;
		this.file = file;
		this.price = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrp() {
		return nrp;
	}
	public void setNrp(String nrp) {
		this.nrp = nrp;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
