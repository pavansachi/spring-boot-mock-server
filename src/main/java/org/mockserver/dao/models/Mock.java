package org.mockserver.dao.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * entity class to represent a mock object
 * @author pavansachi
 *
 */

@Entity
@IdClass(MockKey.class)
public class Mock {

	@Id
	@JsonProperty
	private String method;
	@JsonProperty
	private String path;
	
	public String getResponseType() {
		return responseType;
	}

	private String responseType;
	
	private String response;
	
	public String getResponse() {
		return response;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty
	private String description;

	private Mock() {

	}

}