package org.mockserver.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.MockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

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

	/**
	 * get requests with single path
	 * @param path1
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/**")
	@ResponseBody
	public ResponseEntity<String> get1(final HttpServletRequest request, final HttpServletResponse response) {

		try {
			
			String fullUrl = (String) request.getAttribute(
			        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			
			String appUrl = fullUrl.replace("/rest","");
			
			MockRequest mock = mockDao.findByPath(appUrl);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.valueOf(mock.getResponseType()));
			response.setContentType(mock.getResponseType());

			return new ResponseEntity<String>(mock.getResponse(), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * get requests with three paths
	 * @param path1
	 * @param path2
	 * @param path3
	 * @return
	 */
//	@RequestMapping(method=RequestMethod.GET, value="/{path1:.+}/{path2:.+}/{path3:.+}",
//			produces="application/json")
//	@ResponseBody
//	public ResponseEntity<String> get3(@PathVariable final String path1,
//			@PathVariable final String path2,@PathVariable final String path3) {
//
//		try {
//			Mock mock = mockDao.findByPath(path1, path2, path3);
//
//			return new ResponseEntity<String>(mock.getResponse(), HttpStatus.OK);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//		}
//
//	}

}
