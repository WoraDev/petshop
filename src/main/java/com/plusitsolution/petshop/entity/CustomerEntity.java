package com.plusitsolution.petshop.entity;



import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.plusitsolution.petshop.domain.addressDomain;

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
	private List<addressDomain> address;
	@Field (type = FieldType.Keyword )
	private String contactNumber;
	
	
}
