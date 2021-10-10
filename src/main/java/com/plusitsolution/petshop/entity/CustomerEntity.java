package com.plusitsolution.petshop.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document (indexName = "customer-index")
public class CustomerEntity {
	@Id
	@ReadOnlyProperty
	private String customerID;
	@Field (type = FieldType.Keyword )
	private String firstName;
	@Field (type = FieldType.Keyword )
	private String lastName;
	@Field (type = FieldType.Keyword )
	private String username;
	@Field (type = FieldType.Keyword )
	private String password;
	@Field (type = FieldType.Keyword )
	private String email;
	@Field (type = FieldType.Keyword )
	private String address;
	@Field (type = FieldType.Keyword )
	private String contactNumber;
	public String getId() {
		return customerID;
	}
	public void setId(String id) {
		customerID = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	
}
