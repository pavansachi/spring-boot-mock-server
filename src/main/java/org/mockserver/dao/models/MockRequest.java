package org.mockserver.dao.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * entity class to represent a mock object
 * @author pavansachi
 *
 */

@Entity
public class MockRequest {

	@Id
	@GeneratedValue
	private int requestId;

	private String method;

	private String path;

	private String responseType;

	private String response;

	private String description;
	
	@OneToMany(mappedBy="mockRequest", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<MockRequestParam> paramList = null;
	
	public MockRequest() {

		paramList = new ArrayList<>();
	}

	public List<MockRequestParam> getParamList() {
		return paramList;
	}

	public void setParamList(List<MockRequestParam> paramList) {
		this.paramList = paramList;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

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

}