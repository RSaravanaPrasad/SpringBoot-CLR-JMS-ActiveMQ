package com.message.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@Value
public final class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private final String studentId;

	@JsonProperty
	private final String name;

	@JsonProperty
	private final String rollNumber;

	@ConstructorProperties({"studentId", "name", "rollNumber"})
	public Student(String studentId, String name, String rollNumber){
		this.studentId = studentId;
		this.name = name;
		this.rollNumber = rollNumber;
	}

}
