package com.sk.mathcaptcha.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class Util {
	
	/**
	 * Encoding String using Base64
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String encode(String str) throws Exception {
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(str.getBytes(StandardCharsets.UTF_8));
		return encodedString;
	}

	/**
	 * Decoding String using Base64
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decode(String str) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode(str);		
		return new String(decodedByteArray);

	}
	
	/**
	 * Return a random number
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomNumber(int min, int max) {
		Random random = new Random();
		return random.ints(min, (max + 1)).findFirst().getAsInt();
	}

}
