package com.sk.mathcaptcha;

import java.net.URI;

import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sk.mathcaptcha.model.MathCaptcha;
import com.sk.mathcaptcha.util.Util;

import junit.framework.Assert;

@TestMethodOrder(Alphanumeric.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MathCaptchaApplicationTests {

	@LocalServerPort
	int randomServerPort;

	/***
	 * This will verify the getmathcaptcha service
	 * 
	 * Verifying response status code as 200 Verifying response will contain
	 * MatchCaptcha attributes
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetMathCaptcha() throws Exception {

		System.out.println(" ------------ ");
		System.out.println(" [INFO] -  getmathcaptcha service testing started .. ");

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/myapi/getmathcaptcha/";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		System.out.println("[INFO] - Status Code : " + result.getStatusCodeValue());
		System.out.println("[INFO] - Response : " + result.getBody());
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("Please sum the numbers"));
		Assert.assertEquals(true, result.getBody().contains("randomNumberOne"));
		Assert.assertEquals(true, result.getBody().contains("randomNumberTwo"));
		Assert.assertEquals(true, result.getBody().contains("randomNumberThree"));
		Assert.assertEquals(true, result.getBody().contains("captchaId"));

		System.out.println("[INFO] -  getMathCaptcha service testing completed .. ");
	}

	/***
	 * This will verify the getmathcaptcha service
	 * 
	 * Verifying response status code as 200 Verifying response will contain
	 * MatchCaptcha attributes
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVerifyCaptchaSuccess() throws Exception {
		System.out.println(" ------------ ");
		System.out.println(" [INFO] -  verifycaptcha service testing started .. ");

		int rn1 = 1, rn2 = 2, rn3 = 3;
		String captchaId = Util.encode(String.valueOf((rn1 + rn2 + rn3)));
		MathCaptcha mockMatchCaptcha = new MathCaptcha("Please sum the numbers", rn1, rn2, rn3, captchaId,
				rn1 + rn2 + rn3);

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/myapi/verifycaptcha/";
		HttpEntity<MathCaptcha> request = new HttpEntity<>(mockMatchCaptcha);
		ResponseEntity<?> resp = restTemplate.exchange(baseUrl, HttpMethod.POST, request, ResponseEntity.class);

		System.out.println("[INFO] - Status Code : " + resp.getStatusCodeValue());
		Assert.assertEquals(200, resp.getStatusCodeValue());
		System.out.println("[INFO] -  verifycaptcha service testing completed .. ");
	}
}
