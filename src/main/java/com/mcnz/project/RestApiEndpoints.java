package com.mcnz.project;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/* application.properties must include spring.profiles.active=cameron to run this. */
/* You may also need to update your component scanning to include the com.mcnz.project package. */
@Profile("cameron")
@RestController
@CrossOrigin
public class RestApiEndpoints {
	
	static ArrayList<CameronsRegistration> registrations = new ArrayList<CameronsRegistration>();
	static ArrayList<CameronsEvent> events = new ArrayList<CameronsEvent>();
	static ArrayList<CameronsCustomer> customers = new ArrayList<CameronsCustomer>();
	
	static {  
		CameronsCustomer c1 = new CameronsCustomer(1, "Wayne","99@hotmail.com", "gr3at1");
		CameronsCustomer c2 = new CameronsCustomer(2, "Eric" ,"66@gmail.com", "0sh5w5");
		CameronsCustomer c3 = new CameronsCustomer(3, "Darcy","darcydeclute@gmail.com","scrumtu0u5");
	
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);

	}
	
	static {  
		CameronsEvent c1 = new CameronsEvent(1, "0011","Cars and Coffee", "Fun!");
		CameronsEvent c2 = new CameronsEvent(2, "0022" ,"Java Meetup", "Cool!");
		CameronsEvent c3 = new CameronsEvent(3, "0033","Pig Roast","Yummy!");
		CameronsEvent c4 = new CameronsEvent(4, "0044","Book Launch","Scrum 4 Everyone!");
	
		events.add(c1);
		events.add(c2);
		events.add(c3);
		events.add(c4);
	}
	
	@GetMapping("/api/customers")
	public List<CameronsCustomer> getAllCustomers()
	{	
		return customers;
	}
	
	@GetMapping("/api/customers/{id}")
	public CameronsCustomer getOneSingleCustomer(@PathVariable int id)
	{
		CameronsCustomer customerToGet = getAllCustomers().get(id-1);
		return customerToGet;
	}
	
	@PutMapping("/api/customers/{id}")
	public CameronsCustomer createOrUpdateCustomerInnaClunkyWay(@RequestBody CameronsCustomer newCameronsCustomer, @PathVariable int id) throws Exception
	{

		CameronsCustomer customerToGet=null;
		List<CameronsCustomer> customers = getAllCustomers();
		try {
			customerToGet = getAllCustomers().get(newCameronsCustomer.getId()-1);
			getAllCustomers().set(newCameronsCustomer.getId()-1, newCameronsCustomer);
		} catch (Exception e) {
			newCameronsCustomer.setId(0);
			addOneSingleCustomer(newCameronsCustomer);
		}

		return customerToGet;
	}
	
	@DeleteMapping("/api/customers/{id}")
	public ResponseEntity<?> deleteOneSingleCustomer(@PathVariable int id)
	{
		getAllCustomers().remove(id-1);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/api/customers")
	public ResponseEntity<?> addOneSingleCustomer(@RequestBody CameronsCustomer c) throws Exception
	{
		int identifier = getAllCustomers().size() - 1;
		c.setId(identifier);
		URI location = new URI("http://localhost:8080/abc/def/customers/"+identifier);
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		getAllCustomers().add(c);
		return response;
	}
	
	/* Assume username is unique. This will return one Customer. */
	@GetMapping("/api/byname/{username}")
	public ResponseEntity<?> getCustomersByName(@PathVariable String username)
	{
		System.out.println("Looking for a user with handle: " + username);
		for (CameronsCustomer customer : customers) {
			if (customer.getName().equalsIgnoreCase(username)) {
				// Set the response code to 200 and add the customer to its JSON payload
				ResponseEntity<?> response = ResponseEntity.ok(customer);
				return response;
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	/* Same as the GET mapping but handled by a post. */
	@PostMapping("/api/byname/")
	public ResponseEntity<?> getCustomersByNamePost(@RequestBody String username)
	{
		return getCustomersByName(username);
	}
	
	@GetMapping("/api/events")
	public List<CameronsEvent> getAllEvents()
	{	
		return events;
	}
	
	@GetMapping("/api/events/{id}")
	public CameronsEvent getOneSingleEvent(@PathVariable int id)
	{
		CameronsEvent eventToGet = getAllEvents().get(id-1);
		return eventToGet;
	}
	
	@DeleteMapping("/api/events/{id}")
	public ResponseEntity<?> deleteOneSingleEvent(@PathVariable int id)
	{
		getAllEvents().remove(id-1);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/api/events")
	public ResponseEntity<?> addOneSingleEvent(@RequestBody CameronsEvent event) throws Exception
	{
		int identifier = getAllEvents().size();
		event.setId(identifier);
		URI location = new URI("http://localhost:8080/abc/def/events/"+identifier);
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		getAllEvents().add(event);
		return response;
	}

	@PutMapping("/api/events/{id}")
	public CameronsEvent createOrUpdateEventInnaClunkyWay(@RequestBody CameronsEvent event, @PathVariable int id) throws Exception
	{

		CameronsEvent eventToGet=null;
		List<CameronsEvent> events = getAllEvents();
		try {
			eventToGet = getAllEvents().get(event.getId()-1);
			getAllEvents().set(event.getId()-1, event);
		} catch (Exception e) {
			event.setId(0);
			addOneSingleEvent(event);
		}

		return event;
	}
	
	@GetMapping("/api/registrations")
	public List<CameronsRegistration> getAllRegistrations()
	{	
		return registrations;
	}
	
	@GetMapping("/api/registrations/{id}")
	public CameronsRegistration getOneSingleRegistration(@PathVariable int id)
	{
		CameronsRegistration registrationToGet = getAllRegistrations().get(id);
		return registrationToGet;
	}
	
	@DeleteMapping("/api/registrations/{id}")
	public ResponseEntity<?> deleteOneSingleRegistration(@PathVariable int id)
	{
		getAllRegistrations().remove(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/api/registrations")
	public ResponseEntity<?> addOneSingleRegistration(@RequestBody CameronsRegistration c) throws Exception
	{
		List<CameronsRegistration> registrations = getAllRegistrations();
		int identifier = registrations.size();

		c.setId(identifier);
		URI location = new URI("http://localhost:8080/api/registrations/"+identifier);
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		c.setCustomer_id(c.getCustomer_id()+1);
		getAllRegistrations().add(c);
		return response;
	}
	
	@PutMapping("/api/registrations/{id}")
	public CameronsRegistration createOrUpdateRegistrationInnaClunkyWay(@RequestBody CameronsRegistration registration, @PathVariable int id) throws Exception
	{

		CameronsRegistration registrationToGet=null;
		List<CameronsRegistration> registrations = getAllRegistrations();
		try {
			registrationToGet = getAllRegistrations().get(registration.getId()-1);
			getAllRegistrations().set(registration.getId()-1, registration);
		} catch (Exception e) {
			registration.setId(0);
			addOneSingleRegistration(registration);
		}

		return registration;
	}

	
}
