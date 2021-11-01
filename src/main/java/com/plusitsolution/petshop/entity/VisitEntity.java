package com.plusitsolution.petshop.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(indexName = "visit-index")
public class VisitEntity {
	
	@Id
	private String visitID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty
	private String description;

	private Integer petId;

}
