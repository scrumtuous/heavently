package com.mcnz.project;

public class CameronsEvent {
	int id;
	public CameronsEvent(int id, String code, String title, String description) {
		super();
		this.id=id;
		this.code = code;
		this.title = title;
		this.description = description;
	}
	public CameronsEvent() {};
	String code, title, description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}


/*
 * 
 * [
  {
    "id": 1,
    "code": "CNF001",
    "title": "All-Java Conference",
    "description": "Lectures and exhibits covering all Java topics"
  },
  {
    "id": 2,
    "code": "WKS002",
    "title": "Spring Boot Workshop",
    "description": "Hands-on Spring Boot Workshop"
  },
  {
    "id": 3,
    "code": "TRN003",
    "title": "Angular Training Course",
    "description": "Five day introductory training in Angular"
  },
  {
    "id": 4,
    "code": "ABC123",
    "title": "Classic Car Show",
    "description": "Just a chance to look at cars!"
  },
  {
    "id": 5,
    "code": "abc321",
    "title": "Scrum Master Training",
    "description": "Get scrum certified"
  },
  {
    "id": 6,
    "code": "ABCD123",
    "title": "Event",
    "description": "Aaron's event"
  },
  {
    "id": 7,
    "code": "CMSC999",
    "title": "Intro to Computer Systems",
    "description": "..."
  }
]

*/
