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
@IdClass(MockRequestKey.class)
public class MockRequest {

	@Id
	@JsonProperty
	private String method;
	
	@Id
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

	private MockRequest() {

	}

}