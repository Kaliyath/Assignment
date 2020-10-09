package com.sk.mathcaptcha.data;

import com.sk.mathcaptcha.model.MathCaptcha;

public interface MathCaptchaData {
	
	public MathCaptcha getMathCaptcha();
	
	public boolean verifyCaptcha(MathCaptcha mathCaptcha);

}
