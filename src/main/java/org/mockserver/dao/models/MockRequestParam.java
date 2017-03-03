package org.mockserver.dao.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * entity class to represent an application request param
 * @author pavansachi
 *
 */

@Entity
public class MockRequestParam {

	@Id
	@GeneratedValue
	private int paramId;
	
	@JsonProperty
	private String name;
	
	public MockRequest getMockRequest() {
		return mockRequest;
	}

	public void setMockRequest(MockRequest mockRequest) {
		this.mockRequest = mockRequest;
	}

	@JsonProperty
	private String value;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	  @PrimaryKeyJoinColumns({
//	        @PrimaryKeyJoinColumn(name="method"),
//	        @PrimaryKeyJoinColumn(name="path")
//	    })
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="method"),
		@JoinColumn(name="path")
		})
	private MockRequest mockRequest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MockRequestParam() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockRequestParam other = (MockRequestParam) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
}