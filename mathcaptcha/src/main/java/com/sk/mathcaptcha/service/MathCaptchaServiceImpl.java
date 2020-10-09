package com.sk.mathcaptcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.mathcaptcha.data.MathCaptchaData;
import com.sk.mathcaptcha.model.MathCaptcha;

@Service
public class MathCaptchaServiceImpl implements MathCaptchaService {

	@Autowired
	private MathCaptchaData matchCaptchaData;
	
	public MathCaptcha getMathCaptcha() {
		return matchCaptchaData.getMathCaptcha();
	}
	
	@Override
	public boolean verifyCaptcha(MathCaptcha mathCaptcha) {
		return matchCaptchaData.verifyCaptcha(mathCaptcha);
	}

}
