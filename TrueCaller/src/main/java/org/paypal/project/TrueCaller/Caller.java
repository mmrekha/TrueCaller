package org.paypal.project.TrueCaller;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Call")
public class Caller {
	
	private static List<PhoneBook>  phBook=new ArrayList<PhoneBook>();
	private Database dbConn = new Database();
	

	public void initPhoneBook(){
		phBook=dbConn.retrieve();
	
	}
	
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public  List<PhoneBook> getAllPhoneBook(){
		initPhoneBook();
		return phBook;
		
	}
	@Path("/{username}")
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public  PhoneBook getUserPhoneBook(@PathParam("username") String username){
		initPhoneBook();
		for(PhoneBook p : phBook){
			if(p.getUserName().equals(username))
			{
			//System.out.println("HellO ="  +p.getUserName()+ p.getPhoneBookId() + p.getDateCreated());
			return p;
			}
		}
		
	return null;
}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  List<PhoneBook> addUserPhoneBook(PhoneBook e){
		//initPhoneBook();
		phBook.add(e);
		dbConn.insert(e);
		return phBook;
	}
}
