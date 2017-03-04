package org.mockserver.dao;

import java.util.List;

import org.mockserver.dao.models.MockRequest;
import org.mockserver.dao.models.MockRequestParam;

public interface MockDAO {

	public void createMocks(List<MockRequest> mocks) throws Exception;

	public void createMock(MockRequest mock) throws Exception;
	
	public MockRequest findByPath(String path) throws Exception;
	
	public void createMockParam(MockRequestParam param) throws Exception;
	
	public void createMockParams(List<MockRequestParam> param) throws Exception;
	
//	public MockRequest findByPath(String... path) throws Exception;
	
}
