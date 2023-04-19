package ru.netology.moneytransferservice;

import netscape.javascript.JSObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	static GenericContainer  diploma = new GenericContainer<>("diplom")
			.withExposedPorts(8080);
	@BeforeAll
	public static void setUp() {
		diploma.start();
	}

	@Test
	void contextLoads() {
		HashMap<String, Object> amount = new HashMap<>();
		amount.put("currency","RUR");
		amount.put("value", "132121232111");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("cardFromNumber", "2131242145525534");
		requestMap.put("cardToNumber", "2346434363463266");
		requestMap.put("cardFromCVV", "123");
		requestMap.put("cardFromValidTill", "12/34");
		requestMap.put("amount", amount);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestMap);
		ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:"
				+ diploma.getMappedPort(8080) + "/transfer", httpEntity, String.class);
		Assertions.assertEquals("{\"operationId\":1}", entity.getBody());
	}

}
