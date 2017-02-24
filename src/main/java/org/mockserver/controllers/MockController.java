package org.mockserver.controllers;

import java.util.List;

import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.Mock;
import org.mockserver.models.MockRequest;
import org.mockserver.models.MockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * rest controller for mocks
 * @author pavansachi
 *
 */

@Controller
public class MockController {

	@Autowired
	private MockDAO mockDao;
	
	@RequestMapping(method=RequestMethod.PUT, path="/push/all", consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<MockResponse> setMocks(@RequestBody final List<Mock> mocks) {
		
		try {
			mockDao.createMocks(mocks);
		} catch (Exception e) {
			e.printStackTrace();
			
			return new ResponseEntity<MockResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<MockResponse>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/push", consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<MockResponse> setOneMock(@RequestBody final Mock mock) {
		
		try {
			mockDao.createMock(mock);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<MockResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<MockResponse>(HttpStatus.OK);
	}

}
