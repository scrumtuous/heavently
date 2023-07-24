package com.mcnz.rps;

public class GameSummary {
	
	Long id;
	String clientGesture, serverGesture, result;
	java.sql.Timestamp timePlayed;
	
	public GameSummary() {};
	
	
	public GameSummary(String clientGesture, String serverGesture, String result) {
		super();
		this.clientGesture = clientGesture;
		this.serverGesture = serverGesture;
		this.result = result;
		timePlayed = new java.sql.Timestamp(System.currentTimeMillis());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientGesture() {
		return clientGesture;
	}
	public void setClientGesture(String clientGesture) {
		this.clientGesture = clientGesture;
	}
	public String getServerGesture() {
		return serverGesture;
	}
	public void setServerGesture(String serverGesture) {
		this.serverGesture = serverGesture;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public java.util.Date getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(java.sql.Timestamp timePlayed) {
		this.timePlayed = timePlayed;
	}

}
