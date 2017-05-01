package org.paypal.project.TrueCaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Database {
	
	public  List<Contacts> getDBContacts() {
		List<Contacts> contacts = new ArrayList<Contacts>();
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3300/sys","root","password");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from tc_contacts");
			while(rs.next()) 
				{System.out.println(rs.getInt(1)+"  "+rs.getString(5)+" " +rs.getString(3)+"  "+rs.getString(4)+ " " +rs.getDate(7));  
				contacts.add(new Contacts(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));	
				}//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			}
			catch(Exception e)
			{ System.out.println(e);
			e.printStackTrace();
			} 
		
		return contacts;
	}

	public  String insertContacts(List<Contacts> contacts)
	  {
	    try
	    {

	    	Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3300/sys","root","password");  
	  
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date currDate = new java.sql.Date(calendar.getTime().getTime());

	      for(Contacts contact : contacts ){
	    	  
	       String query = " insert into tc_contacts (phone_book_id,contact_name,contact_ph_no,contact_description,contact_location,created_time)"
	        + " values (?, ?, ?, ?, ?, ?)";

	
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setInt (1, contact.getPhone_book_id());
	      preparedStmt.setString(2, contact.getContact_name());
	      preparedStmt.setString(3, contact.getContact_ph_no());
	      preparedStmt.setString(4, contact.getContact_description());
	      preparedStmt.setString(5, contact.getContact_location());
	      preparedStmt.setDate(6, currDate);
	      preparedStmt.execute();
	  	System.out.println(contact.getContact_name() + " End of DB insert()" + contact.getContact_description());
	      }
	      
	      con.close();
	    
		    return "Insert Successful";
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return "Insert Failure";
	    }

	  }
	public  List<PhoneBook> retrieve() {
		List<PhoneBook> pb = new ArrayList<PhoneBook>();
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3300/sys","root","password");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from tc_phonebook");
			while(rs.next()) 
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" " +rs.getString(3)+"  "+rs.getString(4)+ " " +rs.getDate(5));  
			pb.add(new PhoneBook(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)));	
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			}
			catch(Exception e)
			{ System.out.println(e);
			e.printStackTrace();
			} 
		
		return pb;


	}
	 public  void insert(PhoneBook phBook)
	  {
	    try
	    {

	    	Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3300/sys","root","password");  
	  
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date currDate = new java.sql.Date(calendar.getTime().getTime());

	      // the mysql insert statement
	      String query = " insert into tc_phonebook (username, email, password, create_time)"
	        + " values (?, ?, ?, ?)";

	
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (1, phBook.getUserName());
	      preparedStmt.setString (2, phBook.getEmailID());
	      preparedStmt.setString   (3, phBook.getPassword());
	      preparedStmt.setDate(4, currDate);
	      preparedStmt.execute();
	      
	      con.close();
	    	System.out.println(phBook.getUserName() + " End of DB insert()");
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }
	}

