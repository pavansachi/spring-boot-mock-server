package org.mockserver.dao;

import java.util.List;

import org.mockserver.dao.models.Mock;

public interface MockDAO {

	public void createMocks(List<Mock> mocks) throws Exception;

	public void createMock(Mock mock) throws Exception;
	
	public Mock findByPath(String... path) throws Exception;
	
}
