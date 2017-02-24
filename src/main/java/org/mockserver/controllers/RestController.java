package org.mockserver.controllers;

import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * rest controller for mocks
 * @author pavansachi
 *
 */

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private MockDAO mockDao;
	
	@RequestMapping(method=RequestMethod.GET, value="/{path1:.+}",
			produces="application/json")
	@ResponseBody
	public ResponseEntity<String> get1(@PathVariable final String path1) {
		
		try {
			Mock mock = mockDao.findByPath(path1);
			
			return new ResponseEntity<String>(mock.getResponse(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{path1:.+}/{path2:.+}",
			produces="application/json")
	@ResponseBody
	public ResponseEntity<String> get2(@PathVariable final String path1,
			@PathVariable final String path2) {
		
		try {
			Mock mock = mockDao.findByPath(path1, path2);
			
			return new ResponseEntity<String>(mock.getResponse(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{path1:.+}/{path2:.+}/{path3:.+}",
			produces="application/json")
	@ResponseBody
	public ResponseEntity<String> get3(@PathVariable final String path1,
			@PathVariable final String path2,@PathVariable final String path3) {
		
		try {
			Mock mock = mockDao.findByPath(path1, path2, path3);
			
			return new ResponseEntity<String>(mock.getResponse(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
