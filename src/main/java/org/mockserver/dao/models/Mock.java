package org.mockserver.dao.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@IdClass(MockKey.class)
public class Mock {

	@Id
	@JsonProperty
	private String method;
	@JsonProperty
	private String path;
	
	private String response;
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty
	private String description;

	private Mock() {

	}

}