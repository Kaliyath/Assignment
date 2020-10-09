package com.sk.mathcaptcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.mathcaptcha.model.MathCaptcha;
import com.sk.mathcaptcha.service.MathCaptchaService;

@RestController
@RequestMapping(value = "/myapi")
public class MathCaptchaController {

	@Autowired
	private MathCaptchaService mathCaptchaService;

	@RequestMapping(value = "getmathcaptcha", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public MathCaptcha getMathCaptcha() {
		return mathCaptchaService.getMathCaptcha();
	}
	
	@PostMapping(value = "verifycaptcha", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> verifyCaptcha(@RequestBody MathCaptcha mathCaptcha) {
		boolean status = mathCaptchaService.verifyCaptcha(mathCaptcha);

		if (status)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
