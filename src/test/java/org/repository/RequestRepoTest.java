package org.repository;

import java.util.ArrayList;
import java.util.List;

import org.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.dao.MockDAO;
import org.mockserver.dao.models.MockRequest;
import org.mockserver.dao.models.MockRequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class RequestRepoTest {

	@Autowired
	private MockDAO mockDao;

	//	@Autowired
	//	private MockService mockService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShouldSaveRequest() throws Exception {

		MockRequest req = new MockRequest();

		req.setMethod("GET");
		req.setPath("/hello");
		req.setDescription("GET request with json response");
		req.setResponse("hello world");
		req.setResponseType("application/json");
		//		req.setRequestId(new MockRequestId("GET", "/helloworld"));

		MockRequest req2 = new MockRequest();
		req2.setMethod("GET");
		req2.setPath("/hello");
		req2.setDescription("GET request with json response");
		req2.setResponse("hello world");
		req2.setResponseType("application/json");
		
		MockRequestParam param1 = new MockRequestParam();
		param1.setMockRequest(req);
		param1.setName("type");
		param1.setValue("json");
		
		MockRequestParam param2 = new MockRequestParam();
		param2.setMockRequest(req);
		param2.setName("length");
		param2.setValue("5");

		List<MockRequestParam> paramlist1 = new ArrayList<>();
		paramlist1.add(param1);
		paramlist1.add(param2);
		
		req.setParamList(paramlist1);
		
		MockRequestParam param3 = new MockRequestParam();
		param3.setMockRequest(req2);
		param3.setName("type");
		param3.setValue("json");
		
		MockRequestParam param4 = new MockRequestParam();
		param4.setMockRequest(req2);
		param4.setName("length");
		param4.setValue("10");
		
		List<MockRequestParam> paramlist2 = new ArrayList<>();
		paramlist2.add(param3);
		paramlist2.add(param4);
		
		req2.setParamList(paramlist2);
		
//		mockDao.createMockParams(params);
		
//		mockDao.createMockParam(param);
//		mockDao.createMockParam(param1);

		mockDao.createMock(req);
		mockDao.createMock(req2);

		System.out.println();
	}

	/*@Test
	public void testShouldSaveRequestParams() throws Exception {

		MockRequest req = new MockRequest();
		req.setDescription("POST request with json response");
		req.setResponse("hello world");
		req.setResponseType("application/json");
		req.setRequestId(new MockRequestId("POST", "/hello"));

		MockRequestParam param = new MockRequestParam();
		param.setMockRequest(req);
		param.setName("type");
		param.setValue("json");

		mockDao.createMockParam(param);
	}*/

	/*@Test
	public void testShouldFindByPath() throws Exception {

		MockRequest req = new MockRequest();
		req.setDescription("GET request with json response");
		req.setResponse("hello world");
		req.setResponseType("application/json");
		req.setRequestId(new MockRequestId("GET", "/helloworld"));

		MockRequestParam param = new MockRequestParam();
		param.setMockRequest(req);
		param.setName("type");
		param.setValue("json");

		List<MockRequestParam> paramList = new ArrayList<MockRequestParam>();
		paramList.add(param);

		req.setParamList(paramList);

		mockDao.createMock(req);

		MockRequest actual = mockDao.findByPath("/helloworld", "GET");

		Assert.assertNotNull(actual);
	}*/

	/*@Test
	public void testShouldFindByPathParams() throws Exception {

		MockRequest req = new MockRequest();
		req.setDescription("GET request with json response");
		req.setResponse("hello world");
		req.setResponseType("application/json");
		req.setRequestId(new MockRequestId("GET", "/helloworld"));

		MockRequestParam param = new MockRequestParam();
		param.setMockRequest(req);
		param.setName("type");
		param.setValue("json");

		List<MockRequestParam> paramList = new ArrayList<MockRequestParam>();
		paramList.add(param);

		req.setParamList(paramList);

		mockDao.createMock(req);

		List<MockRequestParam> args = new ArrayList<MockRequestParam>();

		MockRequestParam p1 = new MockRequestParam();
		p1.setName("type");
		p1.setValue("json");

		args.add(p1);

		MockRequest actual = mockDao.findByPathAndParams("/helloworld", "GET", args);

		Assert.assertNotNull(actual);
	}*/

}
