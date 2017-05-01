package org.paypal.project.TrueCaller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ContactService {
	
	//private List<Contacts> contacts = new ArrayList<Contacts>();
	
	public List<Contacts> getAllContacts(){
		return (new Database().getDBContacts());
		 		
	}
	

	public String addUserContacts(List<Contacts> e){
		//initPhoneBook();
		
		return (new Database().insertContacts(e));
	}
	
	
	
	

}
