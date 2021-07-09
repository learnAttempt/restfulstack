package com.solution.webservice.unit;

import static org.junit.Assert.assertNotNull;

import com.solution.webservice.Application;
import com.solution.webservice.model.StackCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = Application.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StackControllerIntegrationTest {
  @Autowired private TestRestTemplate restTemplate;

  @LocalServerPort private int port;
  private static String PATH = "/api/v1/stack";

  private String getRootUrl() {
    return "http://localhost:" + port;
  }

  @Test
  public void contextLoads() {}

  @Test
  public void testPush() {
    StackCustom stackCustom = new StackCustom(10);
    int element = 19;
    ResponseEntity<Integer> postResponse =
        restTemplate.postForEntity(getRootUrl() + PATH + "/" + element, null, Integer.class);
    assertNotNull(postResponse);
    assertNotNull(postResponse.getBody());
  }

  @Test
  public void testGet() {
    StackCustom stackCustom = new StackCustom(10);
    int element = 19;
    ResponseEntity<Integer> postResponse =
        restTemplate.postForEntity(getRootUrl() + PATH + "/" + element, null, Integer.class);
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    ResponseEntity<Integer> response =
        restTemplate.exchange(getRootUrl() + PATH, HttpMethod.GET, entity, Integer.class);
    assertNotNull(response.getBody());
  }


    @Test
    public void testPop() {
      StackCustom stackCustom = new StackCustom(10);
      int element = 13;
      ResponseEntity<Integer> post =
          restTemplate.postForEntity(getRootUrl() + PATH + "/" + element, null, Integer.class);
      ResponseEntity<Integer> postResponse =
          restTemplate.postForEntity(getRootUrl() + PATH ,null,Integer.class);
      assertNotNull(postResponse);
      assertNotNull(postResponse.getBody());
  }
}