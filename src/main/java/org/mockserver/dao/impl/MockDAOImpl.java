package org.mockserver.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.MockRequest;
import org.mockserver.dao.models.MockRequestParam;
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
//		mockRepository.save(mocks);
		
		for (MockRequest mock: mocks) {
			
			createMock(mock);
		}
		
		log.info("mocks are saved");
	}

	@Override
	public void createMock(MockRequest mock) throws Exception {
		
		log.info("createMocks(List(mocks))");
		
		addParams(mock);
		
		mockRepository.save(mock);
		log.info("mock is saved");
		
	}

	private void addParams(MockRequest mock) {
		
		List<MockRequestParam> params = mock.getParams();

		String paramVars = "";
		
		if (mock.getParams() == null) {
			return;
		}
		
		int len = params.size();
		
		if (len > 0) {
			paramVars+= "?";
		}
		
		for (int i=0; i<len; i++) {
			
			MockRequestParam param = params.get(i);
			
			paramVars+= param.getName() + "=" + param.getValue();
			
			if (i != len-1) {
				paramVars+= "&";
			}
			
		}
		
		mock.setPath(mock.getPath() + paramVars);
	}
	
	@Override
	public MockRequest findByPath(String path) throws Exception {

		MockRequest mock = mockRepository.findByPath(path);
		
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
