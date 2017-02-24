package org.mockserver.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MockRequest {

	@JsonProperty
	private String method;
	
	@JsonProperty
	private String path;
	
	@JsonProperty
	private String description;
}
