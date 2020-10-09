package com.sk.mathcaptcha.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.mathcaptcha.model.MathCaptcha;
import com.sk.mathcaptcha.util.Configuration;
import com.sk.mathcaptcha.util.Util;

@Repository
public class MathCaptchaDataImpl implements MathCaptchaData {

	@Autowired
	private Configuration configuration;

	MathCaptcha mathCaptcha;

	/**
	 * getMathCaptcha() 
	 * 
	 * This method will rerun an object of MatchCaptcha It will
	 * contain the a Question, three random numbers and a captchaId
	 * 
	 * captchaId is an encoded value. Its decoded value is using at the time of
	 * result verification
	 * 
	 * Client should not make any changes in captchaId value
	 * 
	 * @return MathCaptcha
	 */
	@Override
	public MathCaptcha getMathCaptcha() {

		int n1, n2, n3, n4;
		try {
			mathCaptcha = new MathCaptcha();
			n1 = Util.getRandomNumber(configuration.getMinimum(), configuration.getMaximum());
			n2 = Util.getRandomNumber(configuration.getMinimum(), configuration.getMaximum());
			n3 = Util.getRandomNumber(configuration.getMinimum(), configuration.getMaximum());
			n4 = n1 + n2 + n3;
			mathCaptcha.setQuestion(configuration.getQuestion());
			mathCaptcha.setRandomNumberOne(n1);
			mathCaptcha.setRandomNumberTwo(n2);
			mathCaptcha.setRandomNumberThree(n3);
			mathCaptcha.setCaptchaId(Util.encode(String.valueOf(n4)));
		} catch (Exception e) {
			System.out.println("[Error] - Exception occured in getMathCaptcha method :" + e);
		}
		return mathCaptcha;
	}

	/**
	 * verifyCaptcha
	 * 
	 * This method will invoke verify method for verifying client response
	 *  
	 * @param mathCaptcha
	 * @return boolean
	 */
	@Override
	public boolean verifyCaptcha(MathCaptcha mathCaptcha) {
		return verify(mathCaptcha);
	}

	/**
	 * verify
	 * 
	 * This method will check the sum of random numbers in the client response
	 * 
	 * Also this decode and verify the captchId in MathCaptcha object the response
	 * 
	 * @param mathCaptcha
	 * @return boolean
	 */
	private boolean verify(MathCaptcha mathCaptcha) {
		try {
			int result = mathCaptcha.getRandomNumberOne() + mathCaptcha.getRandomNumberTwo()
					+ mathCaptcha.getRandomNumberThree();
			String captchaId = mathCaptcha.getCaptchaId();
			if (!captchaId.isEmpty()) {
				String decodeCaptchId = Util.decode(captchaId);
				int id = Integer.parseInt(decodeCaptchId);
				if (result == mathCaptcha.getSum() && result == id)
					return true;
			}
		} catch (Exception e) {
			System.out.println("[Error] - Exception occured in verify method :" + e);
		}
		return false;

	}

}
