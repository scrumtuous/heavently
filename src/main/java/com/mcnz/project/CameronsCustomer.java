package com.mcnz.project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CameronsCustomer {

	@Id
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private String email;
	private String password;
	
	CameronsCustomer() {}

	public CameronsCustomer(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
	
	
}

/*
 * 
 * http://34.239.139.46:8080/api/customers
 * 
 * 
 * 
[
{
  "id": 2,
  "name": "Paul",
  "password": "pass",
  "email": "paul@b.com"
},
{
  "id": 3,
  "name": "Rick",
  "password": "pass",
  "email": "rick@c.com"
},
{
  "id": 4,
  "name": "Cameron",
  "password": "123456",
  "email": "cameron@mcnz.com"
},
{
  "id": 6,
  "name": "Curtis",
  "password": "abcdefg",
  "email": "curtis@example.com"
},
{
  "id": 7,
  "name": "andy@gmail.com",
  "password": null,
  "email": "andy"
},
{
  "id": 8,
  "name": "Aaron",
  "password": null,
  "email": "Aaron@example.com"
},
{
  "id": 9,
  "name": "nn",
  "password": "rr",
  "email": "aa"
},
{
  "id": 11,
  "name": "Jake",
  "password": "pass",
  "email": "jblatt@wowway.com"
},
{
  "id": 12,
  "name": "Test",
  "password": "passtest",
  "email": "test@test.com"
},
{
  "id": 13,
  "name": "chicken",
  "password": "nuggets",
  "email": "abc@email.com"
},
{
  "id": 14,
  "name": "Dougie",
  "password": "ouchie",
  "email": "stuff@example.com"
}
]

*/