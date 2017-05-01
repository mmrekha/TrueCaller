package org.paypal.project.TrueCaller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {
	
	private ContactService contactService = new ContactService();
	
	@GET
	public List<Contacts> getContacts(){
		return contactService.getAllContacts();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addContacts(List<Contacts> contact){
		return contactService.addUserContacts(contact);
	}

}
