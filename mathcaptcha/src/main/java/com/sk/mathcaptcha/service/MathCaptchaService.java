package com.sk.mathcaptcha.service;

import com.sk.mathcaptcha.model.MathCaptcha;

public interface MathCaptchaService {
	
	public MathCaptcha getMathCaptcha();
	
	public boolean verifyCaptcha(MathCaptcha mathCaptcha);

}
