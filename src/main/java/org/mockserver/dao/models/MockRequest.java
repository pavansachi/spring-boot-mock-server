package org.mockserver.dao.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

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
	
	@Transient
	private List<MockRequestParam> params = new ArrayList<MockRequestParam>();
	
	public List<MockRequestParam> getParams() {
		return params;
	}

	public void setParams(List<MockRequestParam> params) {
		this.params = params;
	}

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}