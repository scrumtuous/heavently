package com.webage.cmsa;

import java.net.*;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CustomerGatewayRestAPI {
	
	
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	static {  
		Customer c1 = new Customer("Wayne","99@hotmail.com", "gr3at1");
		Customer c2 = new Customer("Eric" ,"66@gmail.com", "0sh5w5");
		Customer c3 = new Customer("Mario","88@aol.com","p3ngu1ns");
	
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c1);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{	
		return customers;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getOneSingleCustomer(@PathVariable int id)
	{
		Customer customerToGet = getAllCustomers().get(id);
		return customerToGet;
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id)
	{
		getAllCustomers().remove(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/customers")
	public ResponseEntity<?> addBetterCustomer(@RequestBody Customer c) throws Exception
	{
		int identifier = getAllCustomers().size() - 1;
		URI location = new URI("http://localhost:8080/abc/def/customers/"+identifier);
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		getAllCustomers().add(c);
		return response;
	}
	
	@GetMapping("/byname/{username}")
	public List<Customer> getCustomersByName(@PathVariable String username)
	{
		System.out.println(username);
		ArrayList<Customer> matches = new ArrayList<Customer>();
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(username)) {
				matches.add(customer);
			}
		}
		return matches;
	}
	
	@PostMapping("/byname/")
	public List<Customer> getCustomersByNamePost(@RequestBody String username)
	{
		return getCustomersByName(username);
	}
	
}



class Customer {

	private int id;
	private String name;
	private String email;
	private String password;
	
	Customer() {}

	public Customer(String name, String email, String password) {
		super();
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
