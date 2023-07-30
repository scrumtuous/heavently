package com.mcnz.project;

public class CameronsRegistration {
	
	int id;
	String event_id, customer_id, notes;
	java.util.Date registration_date = new java.util.Date();
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(java.util.Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
