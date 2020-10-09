package com.sk.mathcaptcha.model;

/**
 * Captcha data model 
 * @author 
 *
 */
public class MathCaptcha {
	
	private String question;
	private int randomNumberOne;
	private int randomNumberTwo;
	private int randomNumberThree;
	private String captchaId;
	private int sum;
	
	public MathCaptcha() {
	}

	public MathCaptcha(String question, int randomNumberOne, int randomNumberTwo, int randomNumberThree) {
		super();
		this.question = question;
		this.randomNumberOne = randomNumberOne;
		this.randomNumberTwo = randomNumberTwo;
		this.randomNumberThree = randomNumberThree;
	}
	
	public MathCaptcha(String question, int randomNumberOne, int randomNumberTwo, int randomNumberThree, String captchaId) {
		super();
		this.question = question;
		this.randomNumberOne = randomNumberOne;
		this.randomNumberTwo = randomNumberTwo;
		this.randomNumberThree = randomNumberThree;
		this.captchaId = captchaId;
	}
	
	public MathCaptcha(String question, int randomNumberOne, int randomNumberTwo, int randomNumberThree, String captchaId, int sum) {
		super();
		this.question = question;
		this.randomNumberOne = randomNumberOne;
		this.randomNumberTwo = randomNumberTwo;
		this.randomNumberThree = randomNumberThree;
		this.captchaId = captchaId;
		this.sum = sum;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getRandomNumberOne() {
		return randomNumberOne;
	}

	public void setRandomNumberOne(int randomNumberOne) {
		this.randomNumberOne = randomNumberOne;
	}

	public int getRandomNumberTwo() {
		return randomNumberTwo;
	}

	public void setRandomNumberTwo(int randomNumberTwo) {
		this.randomNumberTwo = randomNumberTwo;
	}

	public int getRandomNumberThree() {
		return randomNumberThree;
	}

	public void setRandomNumberThree(int randomNumberThree) {
		this.randomNumberThree = randomNumberThree;
	}

	
	public String getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}	

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "MathCaptcha [question=" + question + ", randomNumberOne=" + randomNumberOne + ", randomNumberTwo="
				+ randomNumberTwo + ", randomNumberThree=" + randomNumberThree + "]";
	}

}
