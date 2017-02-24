package org.integration;

import static org.assertj.core.api.BDDAssertions.then;

import org.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test for integration
 * @author pavansachi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class IntegrationTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

//	@Test
//	public void shouldReturn200WhenGetCityWeather() throws Exception {
//		ResponseEntity<Weather> entity = this.testRestTemplate.getForEntity(
//				"http://localhost:" + this.port + "/weather?city={city}", Weather.class, "sydney");
//
//		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//	}

}
