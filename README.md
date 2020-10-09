# Assignment

This project provides math captcha rest services

## There are two rest services available in this application

## 1) getmathcaptcha
	
	This service will provide an object of MatchCaptcha class to the client. 
	Content type - application/json
	It contains a Question and three random numbers. [Random number range and question is configured through application.properties file]. Also it contains a captchaId and sum attributes. 
	captchaId is an encoded value. Its decoded value is using at the time of result verification. It is used to confirm at the time of verification the question and the answer.	
	
	Note: Client should not make any changes in captchaId value while sending it back to the server.
	
	API Endpoind  - http://localhost:8080/myapi/getmathcaptcha

	Request Method - Get
	
	Response sample:
	
		{
		"question": "Please sum the numbers",
		"randomNumberOne": 8,
		"randomNumberTwo": 9,
		"randomNumberThree": 4,
		"captchaId": "MjE=",
		"sum": 0
	}
	
## 2) verifycaptcha

	This service will verify the client request.  It will verify the sum of random numbers in the client request. 
	Also this decode and verify the captchId for ensure the request has received is previously given to a particular client request. captchId will safeguard the cheating.

	API Endpoind  -  http://localhost:8080/myapi/verifycaptcha
	
	Request method – POST
	Put JSON object in the request body with sum of three random numbers   
	
	Sample Request: 
	
	{
		"question": "Please sum the numbers",
		"randomNumberOne": 8,
		"randomNumberTwo": 9,
		"randomNumberThree": 4,
		"captchaId": "MjE=",
		"sum": 21
	}

Response: Status code 200 for successfully verified request and status code 400 for verification failure.

	
	
## To run the application

	Use mathcaptcha_start.bat file. This file has to be placed in the parent folder of mathcaptcha 
	
	Default Port : 8080 
	Port configuration is property is available in the application.properties file
	
	[Note: If you are using 8080 port for other process, please kill that process and execute bat file,
	       or 
		   Change the port in application.properties file and save the file ]
	
    This batch file will clean and install the application.
	Batch file will execute Junit test cases
	Batch file will start the embedded tomcat server, it will use default port 8080 

## To test the application using Postman

   Please see the UserGuide.docx file 

## Note:

	1) Logging is not included  
	2) Custom Exception handling is not included
	3) Authentication and Authorization is not included 
