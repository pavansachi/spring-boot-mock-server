package org.mockserver.dao;

import java.util.List;

import org.mockserver.dao.models.MockRequest;

public interface MockDAO {

	public void createMocks(List<MockRequest> mocks) throws Exception;

	public void createMock(MockRequest mock) throws Exception;
	
	public MockRequest findByPath(String path) throws Exception;
	
//	public MockRequest findByPath(String... path) throws Exception;
	
}
