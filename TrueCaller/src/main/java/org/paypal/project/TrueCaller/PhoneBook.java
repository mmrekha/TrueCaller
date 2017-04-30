package org.paypal.project.TrueCaller;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class PhoneBook {
	private String userName;
	private int phoneBookId;
	private Date dateCreated;
	private String emailID;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PhoneBook(){}
	public PhoneBook(int phoneBookId,String userName, String emailid,String pwd, Date dateCreated) {
		super();
		this.userName = userName;
		this.phoneBookId = phoneBookId;
		this.dateCreated = dateCreated;
		this.emailID= emailid;
		this.password=pwd;	
	}
	
	public String getUserName() {
		return userName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPhoneBookId() {
		return phoneBookId;
	}
	public void setPhoneBookId(int phoneBookId) {
		this.phoneBookId = phoneBookId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
