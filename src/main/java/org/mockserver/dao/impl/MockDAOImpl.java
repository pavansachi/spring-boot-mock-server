package org.mockserver.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.MockRequest;
import org.mockserver.dao.repositories.MockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MockDAOImpl implements MockDAO {

	private Log log = LogFactory.getLog(MockDAOImpl.class);
	
	@Autowired
	private MockRepository mockRepository;

	@Override
	public void createMocks(List<MockRequest> mocks) throws Exception {

		log.debug("createMocks(List(mocks))");
		mockRepository.save(mocks);
		log.info("mocks are saved");
	}

	@Override
	public void createMock(MockRequest mock) throws Exception {
		
		log.info("createMocks(List(mocks))");
		mockRepository.save(mock);
		log.info("mock is saved");
		
	}

	@Override
	public MockRequest findByPath(String path) throws Exception {

		MockRequest mock = mockRepository.findByPath(path);
		
		System.out.println(mock);
		
		return mock;
	}
	
//	@Override
//	public MockRequest findByPath(String... paths) throws Exception {
//
//		String fullPath = "";
//		
//		if (paths.length > 0) {
//
//			for (int path=0; path < paths.length; path++) {
//				
//				fullPath+="/";
//				fullPath+= paths[path];
//			}
//		}
//		
//		
//		MockRequest mock = mockRepository.findByPath(fullPath);
//		
//		System.out.println(mock);
//		
//		return mock;
//	}
	
}
